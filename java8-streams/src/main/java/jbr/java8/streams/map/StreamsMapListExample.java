package jbr.java8.streams.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamsMapListExample {

  public static void main(String[] args) {
    List<String> list = Arrays.asList(new String[] { "aa1", "cc1", "dd2", "bb1", "aa2", "cc2", "bb2", "dd1" });

    System.out.println("===Original Array Values");
    list.stream()
        .forEach(System.out::println);

    System.out.println("\n===Sorted Array Values - Uppercase");
    list.stream()
        .sorted()
        .map(String::toUpperCase)
        .forEach(System.out::println);

    System.out.println("\nFilter - ends with 2");
    list.stream()
        .filter(p -> p.endsWith("2"))
        .forEach(System.out::println);

    System.out.println("\nFilter - replace 2 to 3 of what ends with 2");
    list.stream()
        .filter(p -> p.endsWith("2"))
        .map(p -> p.endsWith("2") ? p.replace("2", "3") : p)
        .forEach(System.out::println);

    System.out.println("\nmapToObj");
    IntStream.range(1, 6)
        .mapToObj(p -> p + "a")
        .forEach(System.out::println);
  }
}
