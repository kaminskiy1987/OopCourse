package ru.oopcourse.kaminskiy.person_main;

import ru.oopcourse.kaminskiy.person.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> personsList = Arrays.asList(
                new Person("Иван", 22),
                new Person("Сергей", 47),
                new Person("Петр", 10),
                new Person("Максим", 21),
                new Person("Иван", 5)
        );

        String uniqueNames = personsList.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Уникальные имена: " + uniqueNames);


        String allNamesString = personsList.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(allNamesString);

        List<Person> personsUnder18Years = personsList.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        System.out.println("Персоны до 18 лет: " + personsUnder18Years);

        OptionalDouble averageAge = personsUnder18Years.stream()
                .mapToInt(Person::getAge)
                .average();

        averageAge.ifPresent(avg -> System.out.println("Средний возраст: " + avg));

        Map<String, Double> averageAgeByName = personsList.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        averageAgeByName.forEach((p, age) -> System.out.printf("Имя: %s, Средний возраст: %s %n", p, age));

        String namesWithAgesFrom20To45 = personsList.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(namesWithAgesFrom20To45);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Количество элементов: ");
        int elementsCount = scanner.nextInt();

        DoubleStream numbersRoot = DoubleStream.iterate(0, x -> x + 1)
                .map(Math::sqrt)
                .limit(elementsCount);

        numbersRoot.forEach(System.out::println);
    }
}