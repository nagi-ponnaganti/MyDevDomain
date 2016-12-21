/**
 * 
 */
package com.nagihome.java8.methodparam.filter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author nageswararao
 *
 */
public class BinaryOperatorMinByMaxByExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Student s1 = new Student("Shyam", 22, "A");
		Student s2 = new Student("Ram", 23, "A");
		Student s3 = new Student("Mohan", 22, "B");
		Student s4 = new Student("Ramesh", 21, "B");
		List<Student> list = Arrays.asList(s1, s2, s3, s4);
		Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);

		System.out.println("---BinaryOperator.maxBy---");
		Map<String, Optional<Student>> eldestByClassName = list.stream().collect(
				Collectors.groupingBy(Student::getClassName, Collectors.reducing(BinaryOperator.maxBy(ageComparator))));

		eldestByClassName.forEach((k, v) -> System.out.println("Class:" + k + " Age:"
				+ ((Optional<Student>) v).get().getAge() + " Name:" + ((Optional<Student>) v).get().getName()));

		System.out.println("---BinaryOperator.minBy---");

		Map<String, Optional<Student>> yougestByClassName = list.stream().collect(
				Collectors.groupingBy(Student::getClassName, Collectors.reducing(BinaryOperator.minBy(ageComparator))));
		yougestByClassName.forEach((k, v) -> System.out.println("Class:" + k + " Age:"
				+ ((Optional<Student>) v).get().getAge() + " Name:" + ((Optional<Student>) v).get().getName()));

	}

	static class Student {
		private String name;
		private Integer age;
		private String className;

		public Student(String name, Integer age, String className) {
			this.name = name;
			this.age = age;
			this.className = className;
		}

		public String getName() {
			return name;
		}

		public Integer getAge() {
			return age;
		}

		public String getClassName() {
			return className;
		}
	}

}
