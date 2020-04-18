package BaseCourse.Regex._2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /**
         * Quantifiers, Pattern
         */

        // {x} - matching exact number of character
        String alphabet = "abcDeeeghhghghga243bcDeee23";
        System.out.println(alphabet.replaceAll("^abcDe{3}", "X"));

        // + - one or more
        System.out.println(alphabet.replaceAll("^abcDe+", "X"));

        // * - zero or more
        System.out.println(alphabet.replaceAll("^abcDZ*", "X"));

        //{x,y} - matching range of repeated character
        System.out.println(alphabet.replaceAll("^abcDe{2,5}", "X"));

        //example
        System.out.println(alphabet.replaceAll("De+g*", "Y"));

        //Patter and Matcher
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        //after calling matches()
        matcher.reset();

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : "
                    + matcher.start() + " to " + matcher.end());
        }


        String str = "(<h2>)(.+?)(</h2>)";
        Pattern pattern2 = Pattern.compile(str);
        Matcher matcher2 = pattern2.matcher(htmlText);

        while (matcher2.find()) {
            System.out.println("Occurrence : " + matcher2.group(2));
        }


        // "abc" "a" and "b" and "c"
        // [Hh]arry
        System.out.println("harry".replaceAll("(H|h)arry", "Larry"));
        System.out.println("Harry".replaceAll("(H|h)arry", "Larry"));

        // [^abc]
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
        // t(?=v)
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$"));
        System.out.println("phone2 = " + phone2.matches("^[\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4}$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        // ^4[0-9]{12}([0-9]{3})?$
        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));


    }
}
