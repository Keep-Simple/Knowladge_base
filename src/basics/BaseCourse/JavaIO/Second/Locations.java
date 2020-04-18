package basics.BaseCourse.JavaIO.Second;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        /**
         * Writing binary data for each field separate
         */
//        try (DataOutputStream locFile = new DataOutputStream
//                (new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
//            for (Location i : locations.values()) {
//                locFile.writeInt(i.getId());
//                locFile.writeUTF(i.getDescription());
//                locFile.writeInt(i.getExits().size());
//                for (String direction : i.getExits().keySet()) {
//                    locFile.writeUTF(direction);
//                    locFile.writeInt(i.getExits().get(direction));
//                }
//            }
//        }
        /**
         * Writing binary objects data
         * (Location implements empty interface Serializable and its field also do so)
         * We are not caching exception, because method throws it
         */
        try (ObjectOutputStream locFile = new ObjectOutputStream
                (new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location i : locations.values()) {
                locFile.writeObject(i);
            }
        }
    }

    static {
        /**
         * Reading just the binary data of fields
         */
//        try (DataInputStream locFile = new DataInputStream
//                (new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean flag = false;
//            while (!flag) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locId = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    for (int i = 0; i < numExits; i++) {
//                        exits.put(locFile.readUTF(), locFile.readInt());
//                    }
//                    locations.put(locId, new Location(locId, description, exits));
//                } catch (EOFException e) {
//                    flag = true;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /**
         * Reading Objects binary data
         * And putting Location instances inside locations Map
         */
        try (ObjectInputStream locFile = new ObjectInputStream
                (new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean flag = false;
            while (!flag) {
                try {
                    Location temp = (Location) locFile.readObject();
                    locations.put(temp.getId(), temp);
                } catch (EOFException e) {
                    flag = true;
                }
            }
        } catch (InvalidClassException e) { //when serialVersionUID doesn't match
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) { //when object is not Location instance
            e.getException();
        }
    }


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return locations.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return locations.containsValue(o);
    }

    @Override
    public Location get(Object o) {
        return locations.get(o);
    }

    @Override
    public Location put(Integer integer, Location locations) {
        return this.locations.put(integer, locations);
    }

    @Override
    public Location remove(Object o) {
        return locations.remove(o);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> map) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
