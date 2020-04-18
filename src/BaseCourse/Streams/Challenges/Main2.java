package BaseCourse.Streams.Challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        List<String> topNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob");
        //task 1
        topNames.stream()
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println("***********************************");

        //task 2
        long count = topNames.stream()
                .filter(str -> str.substring(0, 1).equalsIgnoreCase("a"))
                .count();

        System.out.println(count);

        System.out.println("***********************************");


        //task 3
        LinkedList<String> list= topNames.stream()
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .peek(System.out::println)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

    }
}
