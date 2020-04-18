package BaseCourse.Collections.Second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Game with locations
 * Class Locations provides name and id of the locations and a HashMap that holds exits to other locations
 * In main method we create HashMap to hold Location instance and its id
 * Than providing possibility to read input (a direction where we want to go from current location)
 * Also creating HashMap<String, String> as vocabulary
 * Reading string line, splitting it with " " and checking for East, West, etc
 */
public class MapChallenge {
    private static HashMap<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "home"));
        locations.put(1, new Location(1, "kindergarten"));
        locations.put(2, new Location(2, "school"));
        locations.put(3, new Location(3, "work"));
        locations.put(4, new Location(4, "shop"));

        locations.get(0).addExit("N", 1);
        locations.get(0).addExit("E", 2);
        locations.get(0).addExit("S", 3);
        locations.get(0).addExit("W", 4);
        locations.get(3).addExit("N", 0);
        locations.get(3).addExit("E", 2);
        locations.get(3).addExit("W", 4);
        locations.get(4).addExit("E", 0);
        locations.get(1).addExit("E", 2);
        locations.get(2).addExit("W", 3);

        int currentLocation = 0;
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
