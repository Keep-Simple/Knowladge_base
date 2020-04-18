package BaseCourse.Streams._1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> nums = Arrays.asList("N40", "N36", "B12","B6",
                "G53", "G49","G60", "G50", "I26", "I17", "I29", "O71");
//
//        nums.forEach(number -> {
//            if(number.startsWith("I"))
//                System.out.println(number);
//        });

        nums.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------");
/**
 * Using stream and collecting result
 */
        List<String> list1 = nums.stream()
                .map(String::toUpperCase)
                .filter(s -> s.contains("I"))
                .sorted()
                .collect(Collectors.toList());
/**
 * Creating own Collector
 */
        List<String> list2 = nums.stream()
                .map(String::toUpperCase)
                .filter(s -> s.contains("I"))
                .sorted()
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        list1.forEach(System.out::println);
        System.out.println("----------------------");
        list2.forEach(System.out::println);


    }
}
