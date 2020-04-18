package BaseCourse.Streams._2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 30);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jack);
        hr.addEmployee(jane);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
        System.out.println("----------------------");
        /**
         * Using flatMap() and collect()
         */

        Map<Integer, List<Employee>> map = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));

        map.forEach(((integer, employees) -> {
            System.out.println(integer);
            employees.forEach(System.out::println);
        }));
        System.out.println("----------------------");

        /**
         * Using terminal method reduce(), getting older employee from 2 Departments
         * ifPresent() works because it's not part of the Stream, its working with reduce output
         */

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);
        System.out.println("----------------------");

    }
}
