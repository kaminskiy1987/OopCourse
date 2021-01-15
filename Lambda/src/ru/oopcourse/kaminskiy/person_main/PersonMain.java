package ru.oopcourse.kaminskiy.person_main;

import ru.oopcourse.kaminskiy.person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Иван", 22),
                new Person("Сергей", 47),
                new Person("Петр", 10),
                new Person("Максим", 21),
                new Person("Иван", 5)
        );

        List<Person> distinctiveNames = list.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("distinctiveNames: " + distinctiveNames);

        String allNamesString = list.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.println("allNamesString: " + allNamesString);

        List<Person> peopleUnder18 = list.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        System.out.println("peopleUnder18: " + peopleUnder18);

        OptionalDouble average = peopleUnder18.stream()
                .mapToDouble(Person::getAge).average();

        System.out.println("average: " + average);

        Map<String, List<Person>> personsByName = list.stream()
                        .collect(Collectors.groupingBy(Person::getName));

        personsByName.forEach((age, p) ->
                System.out.printf("name %s: %s%n", average, p));

        List<Person> namesInDescending = list.stream()
                .filter(p -> p.getAge() > 20 && p.getAge() < 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .collect(Collectors.toList());

        System.out.println("namesInDescending: " + namesInDescending);
    }
}