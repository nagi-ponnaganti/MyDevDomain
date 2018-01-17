package com.nagihome.effective.ch02;

public class StaticFactoryNewInstance {

    public static void main(String[] args) {
        Student stu01 = Student.createStudent("Nagi", "Ponnaganti", "Male", "Aylesbury");
        System.out.println("Student Info: " + stu01.toString());
    }

    // Easy Naming
    // Control number of instances
    // Reduce Verbosity
    // Can return the sub type to return type

}

final class Student {
    private String firstName;
    private String lastName;
    private String sex;
    private String address;

    private Student(String firstName, String lastName, String sex, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Student createStudent(String firstName, String lastName, String sex, String address) {
        return new Student(firstName, lastName, sex, address);
    }
}
