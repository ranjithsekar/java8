package jbr.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Calculating sum of numbers using Stream vs traditional way.
 * 
 * @author Ranjith Sekar (java2ranjith@gmail.com)
 *
 * @date 28-Feb-2017
 */
public class SumUsingStream {
  public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println("Sum: " + SumOld.calcTotal(values));
    System.out.println("Sum of Even: " + SumOld.calcEvenTotal(values));
    System.out.println("Sum of Odd: " + SumOld.calcOddTotal(values));

    System.out.println("Sum: " + values.stream()
        .mapToDouble(i -> i)
        .sum());

    Predicate<Integer> evenPrdicate = i -> i % 2 != 0;
    System.out.println("Sum of Even: " + values.stream()
        .filter(evenPrdicate)
        .mapToDouble(i -> i)
        .sum());

    Predicate<Integer> oddPrdicate = i -> i % 2 != 0;
    System.out.println("Sum of Odd: " + values.stream()
        .filter(oddPrdicate)
        .mapToDouble(i -> i)
        .sum());
  }

}

class SumOld {

  public static Double calcTotal(List<Integer> values) {
    int result = 0;
    for (int i : values) {
      result += i;
    }

    return Double.valueOf(result);
  }

  public static Double calcEvenTotal(List<Integer> values) {
    int result = 0;
    for (int i : values) {
      if (i % 2 == 0) result += i;
    }

    return Double.valueOf(result);
  }

  public static Double calcOddTotal(List<Integer> values) {
    int result = 0;
    for (int i : values) {
      if (i % 2 != 0) result += i;
    }

    return Double.valueOf(result);
  }

}