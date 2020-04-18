package basics.BaseCourse.Regex._1;

public class Main {
    public static void main(String[] args) {
        String str = "Hello, World!";
        // ^ - matching the start of the string
        System.out.println(str.replaceAll("^Hello", "Goodbye"));

        // return false, because matches() must match entire string
        System.out.println(str.matches("^World!"));

        // $ - matching the end of the string
        System.out.println(str.replaceAll("World!$", "Hell"));

        // [] - matching each element
        System.out.println(str.replaceAll("[eo]", "X"));

        // [xy][zw] - matching sequence of 2 characters, 1 out of each group
        System.out.println(str.replaceAll("[eo][l ]", "X"));

        // [^xy] - matching all characters except x and y
        System.out.println(str.replaceAll("[^eo]jf", "X"));

        // [a-c3-9] - matching from range of a,b,c and 3,4...9
        System.out.println(str.replaceAll("[a-x]","X"));

        // (?i) - ignoring case for ascii
        System.out.println(str.replaceAll("(?i)[a-x]","X"));

        // \\d - matching all digits, \\D - matching non digits

        // \\s - matching whitespaces (tabs, etc), \\S - non whitespaces

        // \\w - matching all letters ignoring case, 0-9 and _ , \\W - opposite
        System.out.println("SDLKF.,j9_323".replaceAll("\\w","X"));


        // \\b - surrounding each word with something
        System.out.println(str.replaceAll("\\b", "!"));
    }
}
