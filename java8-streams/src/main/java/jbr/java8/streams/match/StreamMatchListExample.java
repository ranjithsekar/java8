package jbr.java8.streams.match;

import java.util.Arrays;
import java.util.List;

public class StreamMatchListExample {

  public static void main(String[] args) {

    System.out.println("===Matches A");
    List<String> list = Arrays.asList(new String[] { "cc2", "aa2", "bb1", "aa1", "cc1", "bb2" });
    list.stream()
        .map(s ->
          {
            System.out.println("map: " + s);
            return s.toUpperCase();
          })
        .anyMatch(s ->
          {
            System.out.println("anyMatch: " + s);
            return s.startsWith("A");
          });
  }
}
