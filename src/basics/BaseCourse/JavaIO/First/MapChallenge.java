package basics.BaseCourse.JavaIO.First;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Modifying our previous code to start using java.io
 *
 * What was done 1ly:
 * Instead of using hashmap on line 13, created separate class that implements Map interface
 * there we made a static initializer and pasted there code to fill inner hashmap
 *
 * What was done 2ly:
 * Created main() in Locations to write some data to a file, used try-catch blocks to handle IOExceptions
 * Also used block finally that is executed anyway (it solves the following problem) :
 * if during writing to file you got exception, catch block will be performed. So writer won't be closed(close())
 *
 * What was done 3ly:
 * We can delete all catch block and in the main() signature line write : throws IOException
 * Also useful to test that by adding following line in the for-loop : throw new IOException("some text to be shown at runtime");
 *
 * What was done 4ly:
 * Used java 7 feature to re-write code: try with resource block that handles correct closing
 * But main still must have throws IOException or we can have catch block
 *
 * What was done 5ly:
 * In try with resources block added second resource to write directions there
 *
 * What was done 6ly:
 * Commented previous static block
 * Introduce FileReader to fill hashmap
 *
 * What was done 7ly:
 * Read exits by using BufferedReader, used scanner.delimiter() to skip some input
 * Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
 *
 * What was done 8ly:
 * Re-writing all IO blocks using try with resources instead
 * This blocks handles closing our resources properly, no need to use finally block
 *
 * WHEN CALLING MAIN METHOD IN THE LOCATIONS CLASS, STATIC BLOCK EXECUTES FIRSTLY, BECAUSE CLASS MUST BE LOADED
 * BEFORE CALLING MAIN METHOD
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
