package basics.BaseCourse.Streams.Challenges;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //task 1
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            Arrays.asList(parts).forEach(System.out::println);
        };
        new Thread(runnable).start();

        System.out.println("------------------");

        //task 2
        Function<String, String> function = source -> {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < source.length(); i++)
                if (i % 2 == 1)
                    value.append(source.charAt(i));

            return value.toString();
        };


        //task 3
        System.out.println(function.apply("1234567890"));
        //task 4
        System.out.println(task4("1234567890", function));

        //task 5
        Supplier<String> iLoveJava = () -> "I love Java";

        //task 6
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

    }

    //task 4
    public static String task4(String arg, Function<String, String> function) {
        return function.apply(arg);
    }
}
