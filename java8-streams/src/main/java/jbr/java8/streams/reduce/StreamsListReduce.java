package jbr.java8.streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Aim is to sum all persons salary
 * 
 * @author UC139891
 *
 */
public class StreamsListReduce {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Ranjith", 40), new Employee("Kabi", 10));
		Optional<Integer> val = employees.stream().map(e -> e.salary).reduce(Integer::sum);
		System.out.println(val.get());

	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Employee {
	String name;
	Integer salary;
}
