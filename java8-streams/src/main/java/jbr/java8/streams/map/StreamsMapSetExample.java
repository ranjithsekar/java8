package jbr.java8.streams.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMapSetExample {

  public static void main(String[] args) {
    Set<String> mySet = new HashSet<>();
    mySet.addAll(Arrays.asList("2", "1", "4", "3"));

    System.out.println("===Original Set Values");
    Iterator<String> itr = mySet.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

    System.out.println("\n===Original Set Values (using Java8)");
    mySet.forEach(System.out::println);

    System.out.println("\n===Apply Filter");
    mySet.stream()
        .filter(p -> p.equals("3"))
        .forEach(System.out::println);

    // convert to other type
    System.out.println("\n===Change to Integer");
    Set<Integer> intSet = mySet.stream()
        .map(p -> Integer.valueOf(p))
        .collect(Collectors.toSet());
    intSet.forEach(System.out::println);

    System.out.println("\n===Change to Double");
    mySet.stream()
        .mapToDouble(Double::valueOf)
        .forEach(System.out::println);
  }
}
