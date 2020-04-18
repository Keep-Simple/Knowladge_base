package basics.BaseCourse.JavaNIO.ReadingAndWriting._1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * NOW WORKING WITH JAVA NIO WITH IO CLASSES AND SOURCES
 * re-writing Locations main method to create new files using nio
 * re-writing static initializer in Locations to read and put data inside locations map
 *
 * commenting previous code to show how to work with binary objects using nio
 *
 */
public class MapChallenge {
    //private static HashMap<Integer, Location> locations = new HashMap<>();
    private static Locations locations = new Locations();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int currentLocation = 1;
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("NORTH", "N");
        vocabulary.put("QUIT", "Q");

        while (true) {
            System.out.println("Now at : " + locations.get(currentLocation).getDescription());

            Map<String, Integer> exits = locations.get(currentLocation).getExits();

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
            if(str.equals("Q"))
                break;
            if(exits.containsKey(str)) {
                currentLocation = exits.get(str);
            } else {
                System.out.println("You cannot go in that direction");
            }

        }
    }
}
