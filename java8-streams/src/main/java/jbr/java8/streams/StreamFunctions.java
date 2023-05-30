package jbr.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import jbr.java8.streams.model.Gender;
import jbr.java8.streams.model.Person;
import jbr.java8.streams.model.PersonCategory;

/**
 * Examples of Stream Functions (sum, average, et.,)
 * 
 * @author Ranjith Sekar (java2ranjith@gmail.com)
 *
 * @date 28-Feb-2017
 */
public class StreamFunctions {

  public static void main(String[] args) {
    List<Person> persons = Arrays
        .asList(new Person[] { new Person("Sekar", "Chinnappan", Gender.MALE, "Hyderabad", 55, 88000),
            new Person("Ranjith", "Sekar", Gender.MALE, "Chennai", 23, 96000),
            new Person("Kabilan", "Ranjith", Gender.MALE, "Bangalore", 3, 86000),
            new Person("Nivedha", "Ranjith", Gender.FEMALE, "Delhi", 1, 97000) });
    // sum
    int ageSum = persons.stream()
        .filter(PredicateInterface.getCategory(PersonCategory.CHILDREN))
        .mapToInt(p -> p.getAge())
        .sum();
    System.out.println("Age Sum: " + ageSum);

    // average
    OptionalDouble ageAverage = persons.stream()
        .filter(PredicateInterface.getCategory(PersonCategory.CHILDREN))
        .mapToDouble(p -> p.getAge())
        .average();
    System.out.println("Age Average: " + ageAverage.getAsDouble());

  }
}
