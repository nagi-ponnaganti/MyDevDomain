/**
 * 
 */
package com.nagihome.lamdas.objs;

/**
 * @author Nagi
 *
 */
public class Person {

	private String name;
	private PersonSex sex;
	private int age;

	public Person(String name, PersonSex sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonSex getSex() {
		return sex;
	}

	public void setSex(PersonSex sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return " Name: " + this.getName() + " Sex: " + this.getSex()
				+ " Age : " + this.getAge();
	}

}
