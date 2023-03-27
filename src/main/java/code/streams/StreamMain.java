package code.streams;

import code.model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                Person.builder()
                        .name("Mihai")
                        .age(23)
                        .jobTitle("Student")
                        .build(),
                Person.builder()
                        .name("Ioana")
                        .age(32)
                        .jobTitle("Teacher")
                        .build(),
                Person.builder()
                        .name("Mirela")
                        .age(23)
                        .jobTitle("Human resources")
                        .build()
        );

        Stream<Person> stream = persons.stream();

        List<Person> result = persons.stream()
                .filter(person -> person.getAge() > 30)
                .filter(person -> person.getName().startsWith("I"))
                .toList();

        System.out.println(result);
        System.out.println(persons);

        List<Integer> namesLength = persons.stream()
                .map(Person::getName)
                .map(String::length)
                .toList();
        System.out.println(namesLength);

        List<Person> skipFirst = persons.stream()
                .skip(1)
                .toList();

        System.out.println(skipFirst);

        List<Person> limitPersons = persons.stream()
                .limit(2)
                .toList();
        System.out.println(limitPersons);

        List<Integer> integers = List.of(1, 2, 4, 2, 3, 1, 5, 4, 33, 22);
        List<Integer> distinctIntegers = integers.stream()
                .distinct()
                .toList();
        System.out.println(distinctIntegers);
        Set<Integer> collect = persons.stream()
                .map(Person::getAge)
                .collect(Collectors.toSet());


        long count = persons.stream()
                .filter(person -> person.getJobTitle().startsWith("T"))
                .count();
        System.out.println(count);

        boolean major = persons.stream()
                .allMatch(person -> person.getAge() > 18);
        System.out.println(major);

        boolean anyMatch = persons.stream()
                .anyMatch(person -> person.getAge() > 30);
        System.out.println(anyMatch);

        Optional<Person> personFound = persons.stream()
                .filter(person -> person.getAge() > 40)
                .findFirst();

        OptionalInt max = IntStream.range(0, 10)
                .filter(number -> number % 3 == 0)
                .max();
        if (max.isPresent()) {
            System.out.println(max.getAsInt());
        }

        List<Integer> sortedNatural = integers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNatural);

        List<Integer> sortedReversed = integers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sortedReversed);

        List<Person> sortedByName = persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();

        System.out.println(sortedByName);
    }
}
