package jbr.java8.streams.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamsFilterListExample {

  public static void main(String[] args) {

    List<String> list = Arrays.asList(new String[] { "Bala", "Anbu", "Dinesh", "Chandru" });

    System.out.println("===Original List");
    list.forEach(System.out::println);

    System.out.println("\n===Original List - Sorted");
    list.stream()
        .sorted()
        .forEach(System.out::println);

    System.out.println("\n===Name contains - A");
    list.stream()
        .filter(p -> p.contains("A"))
        .forEach(System.out::println);

    System.out.println("\n===Name contains - u");
    Predicate<String> u = p -> p.contains("u");
    list.stream()
        .filter(u)
        .forEach(System.out::println);

    System.out.println("\n===Name contains - u but not A");
    Predicate<String> notA = p -> p.startsWith("A");
    list.stream()
        .filter(u.and(notA.negate()))
        .forEach(System.out::println);

    System.out.println("\n===filter and forEach");
    list.stream()
        .filter(p ->
          {
            System.out.println("Inside filter: " + p);
            return true;
          })
        .forEach(p ->
          {
            System.out.println("Inside forEach: " + p);
          });

    System.out.println("\n===Order of Processing");
    list.stream()
        .map(p ->
          {
            System.out.println("Inside map: " + p);
            return p.toUpperCase();
          })
        .filter(p ->
          {
            System.out.println("Inside filter: " + p);
            return p.startsWith("A");
          })
        .forEach(p ->
          {
            System.out.println("Inside forEach: " + p);
          });
  }
}
