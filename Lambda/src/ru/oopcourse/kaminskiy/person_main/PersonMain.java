package ru.oopcourse.kaminskiy.person_main;

import ru.oopcourse.kaminskiy.person.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> personsList = Arrays.asList(
                new Person("Иван", 22),
                new Person("Сергей", 47),
                new Person("Петр", 10),
                new Person("Максим", 21),
                new Person("Иван", 5)
        );

        List<Person> uniquePersons = personsList.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Уникальные персоны: " + uniquePersons);

        String allNamesString = personsList.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(allNamesString);

        List<Person> filteredPersons = personsList.stream()
                .filter(p -> p.getAge() < 18)
                .collect(Collectors.toList());

        System.out.println("Персоны до 18 лет: " + filteredPersons);

        OptionalDouble arithmeticalMean =
                filteredPersons.stream()
                        .mapToDouble(Person::getAge)
                        .average();

        arithmeticalMean.ifPresent(avg -> System.out.println("Средний возраст: " + avg));

        Map<String, Double> averageAgeByName =
                personsList.stream()
                        .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        averageAgeByName.forEach((p, age) ->
                System.out.printf("Имя: %s, Средний возраст: %s %n", p, age));

        String filteredNames = personsList.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Имена: ", "."));

        System.out.println(filteredNames);
    }
}