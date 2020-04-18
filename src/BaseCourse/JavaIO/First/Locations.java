package BaseCourse.JavaIO.First;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location i : locations.values()) {
//                locFile.write(i.getId() + ", " + i.getDescription() + "\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally { //executes anyway
//            try {
//                if (locFile != null)
//                    locFile.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        /**
         * TRY WITH RESOURCES
         */
        //writing information to files
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location i : locations.values()) {
                locFile.write(i.getId() + "," + i.getDescription() + "\n");
                for (String j : i.getExits().keySet()) {
                    dirFile.write(i.getId() + "," + j +
                            "," + i.getExits().get(j) + "\n");
                }
            }
        }

    }

    static {
        /**
         * Regular style to work with files
         */
        //no need to close FileReader too, because Scanner method close will take care of it
        //reading location id and description
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("locations.txt"));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Read location: " + loc + " : " + description);
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null)
//                scanner.close();
//        }
        //reading exits
//        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()) {
//               String[] data = scanner.nextLine().split(",");
//               int loc = Integer.parseInt(data[0]);
//               String direction = data[1];
//               int dest = Integer.parseInt(data[2]);
//                System.out.println(loc + "," + direction + "," + dest);
//                locations.get(loc).addExit(direction, dest);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null)
//                scanner.close();
//        }
        /**
         * Working with files using try with resources
         */
        try (Scanner scanner = new Scanner (new BufferedReader(new FileReader("locations.txt")))){
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            int loc = scanner.nextInt();
            scanner.skip(scanner.delimiter());
            String description = scanner.nextLine();
            System.out.println("Read location: " + loc + " : " + description);
            locations.put(loc, new Location(loc, description));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

        try(Scanner scanner = new Scanner (new BufferedReader(new FileReader("directions.txt")))) {
        scanner.useDelimiter(",");
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            int loc = Integer.parseInt(data[0]);
            String direction = data[1];
            int dest = Integer.parseInt(data[2]);
            System.out.println(loc + "," + direction + "," + dest);
            locations.get(loc).addExit(direction, dest);
        }
    } catch (IOException e) {
        e.printStackTrace();
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
