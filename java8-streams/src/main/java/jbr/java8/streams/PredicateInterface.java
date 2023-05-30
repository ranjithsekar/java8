package jbr.java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import jbr.java8.streams.model.Gender;
import jbr.java8.streams.model.Person;
import jbr.java8.streams.model.PersonCategory;

/**
 * Examples of Predicate Interface. Predicate Interface will be used when we need to represent a boolean expression that
 * will use the Object (T).
 * 
 * @author Ranjith Sekar (java2ranjith@gmail.com)
 *
 * @date 28-Feb-2017
 */
public class PredicateInterface {

  public static void main(String[] args) {
    List<Person> persons = Arrays
        .asList(new Person[] { new Person("Sekar", "Chinnappan", Gender.MALE, "Hydrabad", 55, 88000),
            new Person("Ranjith", "Sekar", Gender.MALE, "Chennai", 23, 96000),
            new Person("Kabilan", "Ranjith", Gender.MALE, "Bangalore", 3, 86000),
            new Person("Nivedha", "Ranjith", Gender.FEMALE, "Delhi", 1, 97000) });

    persons.stream()
        .filter(getCategory(PersonCategory.OLD))
        .forEach(Person::firstNameFirst);
  }

  public static Predicate<Person> getCategory(PersonCategory category) {
    Map<PersonCategory, Predicate<Person>> categories = new HashMap<PersonCategory, Predicate<Person>>();

    Predicate<Person> children = p -> p.getAge() < 12;
    Predicate<Person> teenage = p -> p.getAge() > 12 && p.getAge() < 25;
    Predicate<Person> older = p -> p.getAge() > 25;

    categories.put(PersonCategory.CHILDREN, children);
    categories.put(PersonCategory.TEEN, teenage);
    categories.put(PersonCategory.OLD, older);

    return categories.get(category);
  }

}