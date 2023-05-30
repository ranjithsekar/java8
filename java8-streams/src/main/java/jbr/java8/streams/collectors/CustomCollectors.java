package jbr.java8.streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

import jbr.java8.streams.model.Gender;
import jbr.java8.streams.model.Person;

public class CustomCollectors {

  public static void main(String[] args) {
    List<Person> persons = Arrays.asList(new Person[] { new Person("A", "a", Gender.MALE, "Hydrabad", 55, 88000),
        new Person("B", "b", Gender.MALE, "Chennai", 23, 96000),
        new Person("C", "c", Gender.MALE, "Bangalore", 3, 86000),
        new Person("D", "d", Gender.FEMALE, "Delhi", 1, 97000) });
    /**
     * T - the type of input elements to the reduction operation A - the mutable accumulation type of the reduction
     * operation (often hidden as an implementation detail) R - the result type of the reduction operation
     **/
    // Collector<T, A, R> nameCollector = Collector.of(supplier, accumulator, combiner, characteristics)
    Collector<Person, StringJoiner, String> nameCollector = Collector.of(() -> new StringJoiner("|"),
        (list, person) -> list.add("LastName: " + person.getLastname()
            .toUpperCase()),
        (list1, list2) -> list1.merge(list2), StringJoiner::toString);

    String allNames = persons.stream()
        .collect(nameCollector);
    System.out.println(allNames);
  }
}
