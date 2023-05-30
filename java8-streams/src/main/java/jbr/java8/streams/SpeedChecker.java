package jbr.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Performance check for regular for-loop vs stream() vs parallelStream() method.
 * 
 * @author Ranjith Sekar (java2ranjith@gmail.com)
 *
 * @date 28-Feb-2017
 */
public class SpeedChecker {

  public static void main(String[] args) {

    Random random = new Random();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 100000; i++) {
      list.add(random.nextInt());
    }
    System.out.println("Calculating..........");

    long startTime1 = System.currentTimeMillis();
    int result1 = 0;
    for (int i : list) {
      result1 += calc(i);
    }
    System.out.println("Traditional Method - using for loop");
    System.out.println("-----------------------------------");
    System.out
        .println("Result is:" + result1 + " took: " + (System.currentTimeMillis() - startTime1) + " milliseconds");

    System.out.println("\nJava 8 - Using stream() method");
    System.out.println("-----------------------------------");
    long startTime2 = System.currentTimeMillis();
    int result2 = list.stream()
        .map(i -> calc(i))
        .reduce(Integer::sum)
        .get();
    System.out
        .println("Result is:" + result2 + " took: " + (System.currentTimeMillis() - startTime2) + " milliseconds");

    System.out.println("\nJava 8 - Using parallelStream() method");
    System.out.println("-----------------------------------");
    long startTime3 = System.currentTimeMillis();
    int result3 = list.parallelStream()
        .map(i -> calc(i))
        .reduce(Integer::sum)
        .get();
    System.out
        .println("Result is:" + result3 + " took: " + (System.currentTimeMillis() - startTime3) + " milliseconds");
  }

  public static int calc(int input) {
    for (int i = 1; i < 10000; i++) {
      input = ((input / 35) * 34) % 5;
    }

    return input;
  }
}
