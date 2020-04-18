package BaseCourse.JavaIO.Second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created second version of classes to show how binary data works
 * Re-writing to DataInputStream and DataOutPutStream
 *
 * When reading binary data, created inner try catch block in another try-catch to
 * understand when file has ended, without stacking different mistakes (EOFException)
 * that is end of file exception
 *
 * Read and Write now with Objects binary data
 * To work with Objects of class in binary data - ObjectOutputStream, and ObjectInputStream
 * We should implement empty interface Serializable and make sure that all fields also implementing Serializable
 * Also we must declare long serialVersionUID to avoid mistakes, when different compilers will produce distinct default values
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
