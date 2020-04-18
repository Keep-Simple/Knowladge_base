package basics.BaseCourse.JavaIO.Third;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Creating and filling RandomAccessFile
 * It doesnt have ability to work with objects, just fields
 * <p>
 * Class IndexRecord stores lengths and starting point
 * Map index stores IndexRecords instances by key(location id)
 * <p>
 * method seek(int a) moves pointer to asked position a
 * <p>
 * creating method close to close RandomAccessFile after reading is finished
 * creating method getLocation to get Location by its id from file
 */
public class Locations {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {

        /**
         * Creating random access file and writing data
         */

        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {
            rao.write(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;
            int locationStart = (int) (rao.getFilePointer() + indexSize + Integer.BYTES);
            rao.write(locationStart);
            //saving position to write index later
            //because we don't know all components of the index, such as exact location lengths in bytes
            long indexStart = rao.getFilePointer();

            //startPointer is needed to calculate size of the exact location
            int startPointer = locationStart;
            rao.seek(startPointer);
            /**
             * Writing locations firstly, skipping space for indexes
             */
            for (Location i : locations.values()) {
                rao.writeInt(i.getId());
                rao.writeUTF(i.getDescription());
                StringBuilder str = new StringBuilder();
                for (String k : i.getExits().keySet()) {
                    if (!k.equalsIgnoreCase("Q")) {
                        str.append(k);
                        str.append(",");
                        str.append(i.getExits().get(k));
                        str.append(",");
                    }
                }
                rao.writeUTF(str.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                //saving record to the map
                index.put(i.getId(), record);
                //increasing startPointer
                startPointer = (int) rao.getFilePointer();
            }
            //writing indexes
            rao.seek(indexStart);
            for (Integer id : index.keySet()) {
                rao.writeInt(id);
                rao.writeInt(index.get(id).getStartByte());
                rao.writeInt(index.get(id).getLengths());
            }
        }
    }

    static {
        /** Collecting indexes to a map
         *  Whenever class is created, to easily access locations
         */
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLoc = ra.readInt();
            int locStart = ra.readInt();

            while (ra.getFilePointer() < locStart) {
                int id = ra.readInt();
                int startByte = ra.readInt();
                int locLengths = ra.readInt();
                index.put(id, new IndexRecord(startByte, locLengths));
            }
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        }
    }

    public Location getLocation(int id) throws IOException {
        IndexRecord record = index.get(id);
        ra.seek(record.getStartByte());
        //skipping location id, cause we already know it
        ra.skipBytes(Integer.BYTES);
        String description = ra.readUTF();
        String exits = ra.readUTF();
        //reading exits
        Map<String, Integer> temp = new LinkedHashMap<>();
        String[] exitsAr = exits.split(",");

        for (int i = 0; i < exitsAr.length; i++) {
            String direction = exitsAr[i];
            int destination = Integer.parseInt(exitsAr[++i]);
            temp.put(direction, destination);
        }

        return new Location(id, description, temp);
    }

    public void close() throws IOException {
        ra.close();
    }
}
