package jbr.java8.streamstype;

import java.util.stream.IntStream;

public class IntStreamExample {

  public static void main(String[] args) {
    IntStream.range(3, 5)
        .forEach(System.out::println);

    System.out.println("\n");
    IntStream.rangeClosed(3, 5)
        .forEach(System.out::println);

  }
}
