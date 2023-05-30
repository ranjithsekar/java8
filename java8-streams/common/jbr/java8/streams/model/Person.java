package jbr.java8.streams.model;

import java.util.Map;
import java.util.function.Function;

/**
 * POJO for Person.
 * 
 * @author Ranjith Sekar (java2ranjith@gmail.com)
 *
 * @date 28-Feb-2017
 */
public class Person {

  private String firstname;
  private String lastname;
  private Gender gender;
  private String address;
  private Integer age;
  private int phone;

  public Person() {

  }

  public Person(String fName, String lName, Gender gender, String addr, int age, int ph) {
    this.firstname = fName;
    this.lastname = lName;
    this.gender = gender;
    this.address = addr;
    this.age = age;
    this.phone = ph;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public String printMe(Function<Person, String> f) {
    return f.apply(this);
  }

  public Map<String, String> printMeMap(Function<Person, Map<String, String>> f) {
    return f.apply(this);
  }

  public void firstNameFirst() {
    System.out.println("Name: " + this.getFirstname() + "," + this.getLastname() + "\nAddress: " + this.getAddress()
        + "\nPhone: " + this.getPhone());
  }

  public void lastNameFirst() {
    System.out.println("Name: " + this.getLastname() + "," + this.getFirstname() + "\nAddress: " + this.getAddress()
        + "\nPhone: " + this.getPhone());
  }

  public static String getName() {
    Person p = new Person();
    return p.getFirstname() + "," + p.getLastname();
  }

  @Override
  public String toString() {
    return this.firstname + ", " + this.lastname;
  }
}
