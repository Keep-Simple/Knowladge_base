package basics.BaseCourse.JavaIO.Third;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Creating RandomAccessFile
 * For reading only needed item, this will save memory.(Recommended to use sql)
 *
 * bytes 0-3 will contain number of Location instances,
 * 4-7 will contain the start offset of the Location section
 * 8-1699 will contain indexes
 * 1700-... contains locations
 * each location contains id, description, exits (N,3,S,5,W,2,...)
 * each index contains location id, location object lengths, where to start reading from
 *
 * Creating field RandomAccessFile to update static initializer
 * that now will be able to randomly read from a file
 *
 * Other notes are in the Locations class
 * We no longer need Locations class to implement Map interface, cause we don't need it with random access file
 * So re-writing main method here
 */
public class MapChallenge {
    //private static HashMap<Integer, Location> locations = new HashMap<>();
    private static Locations locations = new Locations();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int currentLocation = 1;
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("NORTH", "N");
        vocabulary.put("QUIT", "Q");

        Location currentLoc = locations.getLocation(1);
        while (true) {
            System.out.println("Now at : " + currentLoc.getDescription());

            Map<String, Integer> exits = currentLoc.getExits();

            System.out.println("Available directions");
            for (String i : exits.keySet()) {
                System.out.print(i + " ");
            }
            System.out.println();

            String str = scanner.nextLine().toUpperCase();
            if (str.length() > 1) {
                String[] words = str.split(" ");
                for (String i : words) {
                    if (vocabulary.containsKey(i)) {
                        str = vocabulary.get(i);
                        break;
                    }
                }
            }
            if (str.equals("Q"))
                break;
            if (exits.containsKey(str)) {
                currentLoc = locations.getLocation(exits.get(str));
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
            locations.close();
    }
}
