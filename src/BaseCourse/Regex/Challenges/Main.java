package BaseCourse.Regex.Challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //task 1
        String str1 = "I want a bike.";
        System.out.println(str1.matches("I want a bike."));

        //task 2
        String str2 = "I want a ball.";
        String regex = "I want a \\w+.";
        String regex1 = "I want a b(ike|all).";
        System.out.println(str2.matches(regex1));
        System.out.println(str1.matches(regex1));

        //task 3
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher1 = pattern1.matcher(str2);
        System.out.println(matcher1.matches());
        //reusing matcher, because we are checking with same regex
        matcher1 = pattern1.matcher(str1);
        System.out.println(matcher1.matches());

        //task 4
        String str3 = "Replace all blanks with underscores.";
        System.out.println(str3.replaceAll("\\s+", "_"));

        //task 5
        String str4 = "aaabccccccccdddefffg";
        String regex2 = "^a{3}bc{8}d{3}ef{3}g$";
        String regex3 = "[a-g]+";
        System.out.println(str4.matches(regex3));

        //task 6
        String regex4 = "^([a-zA-Z]+\\.\\d+)$";
        System.out.println("aBcde.3443".matches(regex4));

        //task 7
        String regex5 = "[a-zA-Z]+\\.(\\d+)";
        Pattern pattern2 = Pattern.compile(regex5);
        Matcher matcher2 = pattern2.matcher("abcd.135uvqz.7txik.999");

        while (matcher2.find()) {
            System.out.println("Occurrence : " + matcher2.group(1));
        }

        //task 8
        String regex6 = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern pattern3 = Pattern.compile(regex6);
        Matcher matcher3 = pattern3.matcher("abcd.135\tuvqz.7\ttxik.999\n");

        while (matcher3.find()) {
            System.out.println("Occurrence : " + matcher3.group(1));
        }

        //task 9
        String regex7 = "[a-zA-Z]+\\.(\\d+)\\s";
        Pattern pattern4 = Pattern.compile(regex7);
        Matcher matcher4 = pattern4.matcher("abcd.135\tuvqz.7\ttxik.999\n");

        while (matcher4.find()) {
            System.out.println("Occurrence : " + matcher4.start(1) +
                    " " + (matcher4.end(1) - 1));
        }

        //task 10
        String regex8 = "\\{(.+?)\\}";
        Pattern pattern5 = Pattern.compile(regex8);
        Matcher matcher5 = pattern5.matcher("{0, 2}, {0, 5}, {1, 3}");

        while (matcher5.find()) {
            System.out.println("Found : " + matcher5.group(1));
        }

        //task 11
        String string = "11111-1111";
        System.out.println(string.matches("^(\\d{5}-\\d{4})$"));

        //task 12
        String regex9 = "^\\d{5}($|-\\d{4}$)";
        System.out.println(string.matches(regex9));
        System.out.println("11111".matches(regex9));

    }

}
