package basics.BaseCourse.JavaNIO.ReadingAndWriting._1;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
/**
 * Working with binary object data
  */
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) {
            for (Location i : locations.values()) {
                locFile.writeObject(i);
            }
        }
/**
 * Working with character data
 */
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("direction_big.txt");
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
//
//            for (Location i : locations.values()) {
//                locFile.write(i.getId() + "," + i.getDescription() + "\n");
//                for (String dir : i.getExits().keySet()) {
//                    dirFile.write(i.getId() + "," + dir
//                            + "," + i.getExits().get(dir) + "\n");
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("ror");
//        }
    }

     static {
/**
 * Working with binary object data
 */
         Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean flag = false;
            while (!flag) {
                try {
                    Location loc = (Location) locFile.readObject();
                    locations.put(loc.getId(), loc);
                } catch (EOFException e) {
                    flag = true;
                }
            }
        } catch (InvalidClassException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
/**
 * Working with character data
 */
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("direction_big.txt");
//
//        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//            String input;
//            while ((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String dir = data[1];
//                int destination = Integer.parseInt(data[2]);
//                locations.get(loc).addExit(dir,destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
