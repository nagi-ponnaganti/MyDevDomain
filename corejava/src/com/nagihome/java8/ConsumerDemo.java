/**
 * 
 */
package com.nagihome.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author nageswararao
 *
 */
public class ConsumerDemo {

	public static void main(String[] args) {

		Student nagi = new Student("Nagi Ponnaganti", 30, "Male");
		Student moni = new Student("Moni Gutta", 27, "Female");

		List<Student> stus = new ArrayList<Student>();
		stus.add(nagi);
		stus.add(moni);

		System.out.println("Lambda way: ");
		stus.forEach((x) -> x.printData());

		System.out.println("Method Reference");
		stus.forEach(Student::printData);

		System.out.println("Consumer Style");
		Consumer<Student> consumerStu = (s) -> s.printData();
		stus.forEach(consumerStu);

	}
}

class Student {

	/**
	 * @param name
	 * @param age
	 * @param sex
	 */
	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	private String name;
	private int age;
	private String sex;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public void printData() {
		System.out.println(this.toString());
	}

}
