package BaseCourse.Lambda._3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Showing usage of Predicate interface
 */
public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 36);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);


        Predicate<Employee> p = employee -> employee.getAge() > 30;
        Predicate<Employee> b = employee -> employee.getAge() <= 30;
        printByAge(employees, p);
        printByAge(employees, b);

        Function<Employee, String> a = employee -> employee.getName().substring(employee.getName().indexOf(" ") + 1);
        printSecondName(employees, a);
    }

    public static void printByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
        System.out.println("===================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }

    public static void printSecondName(List<Employee> employees, Function<Employee, String> func) {
        System.out.println("=============");
        for (Employee employee : employees) {
            System.out.println(func.apply(employee));
        }
    }
}
