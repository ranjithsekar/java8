package jbr.java8.streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jbr.java8.streams.model.Gender;
import jbr.java8.streams.model.Person;

public class StreamsCollectorListExample {

  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(new Person[] { new Person("A", "a", Gender.MALE, "Hydrabad", 55, 88000),
        new Person("B", "b", Gender.MALE, "Chennai", 23, 96000),
        new Person("C", "c", Gender.MALE, "Bangalore", 3, 86000),
        new Person("D", "d", Gender.FEMALE, "Delhi", 1, 97000) });

    System.out.println("===Collectors.toList()");
    List<Person> male = persons.stream()
        .filter(p -> p.getGender() == Gender.MALE)
        .collect(Collectors.toList());
    male.forEach(s -> System.out.println(s.getFirstname()));

    System.out.println("\n===Collectors.groupingBy() - Age");
    Map<Integer, List<Person>> groupByAge = persons.stream()
        .collect(Collectors.groupingBy(Person::getAge));
    groupByAge.forEach((age, p) -> System.out.format("Age %s: Name %s\n", age, p));

    System.out.println("\n===Collectors.groupingBy() - Gender");
    Map<Gender, List<Person>> groupByGender = persons.stream()
        .collect(Collectors.groupingBy(Person::getGender));
    groupByGender.forEach((age, p) -> System.out.format("Age %s: Name %s\n", age, p));

    System.out.println("\n===Collectors.groupingBy() - Even");
    List<Integer> numbers = Arrays.asList(new Integer[] { 2, 1, 3, 5, 4 });
    Map<Object, List<Integer>> evenNos = numbers.stream()
        .collect(Collectors.groupingBy(p -> p % 2 == 0));
    evenNos.forEach((o, evenNo) -> System.out.println(evenNo + " -> " + o));

    System.out.println("\n===Collectors.averagingInt() - Average Age");
    Double averageAge = persons.stream()
        .collect(Collectors.averagingInt(Person::getAge));
    System.out.println(averageAge);

    System.out.println("\n===Collectors.joining() - Male Persons");
    System.out.println(persons.stream()
        .filter(g -> Gender.MALE == g.getGender())
        .map(p -> p.getFirstname())
        .collect(Collectors.joining(",", "These persons: ", " are Male")));

    System.out.println("\n===Collectors.toMap() - Age -> Name");
    persons.stream()
        .collect(Collectors.toMap(p -> p.getFirstname(), p -> p.getAge()))
        .entrySet()
        .stream()
        .forEach(System.out::println);
  }
}
