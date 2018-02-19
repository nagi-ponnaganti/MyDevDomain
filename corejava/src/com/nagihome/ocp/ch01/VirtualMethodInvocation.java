package com.nagihome.ocp.ch01;

public class VirtualMethodInvocation {


    public static void main(String[] args) {

        Animal l = new Lion();
        Animal c = new Cow();
        Animal b = new Bird();

        l.feed();
        c.feed();
        b.feed();

        l.printName();
        c.printName();
        b.printName();

        l.careFor();
        c.careFor();
        b.careFor();

        System.out.printf("l: %s, c: %s, b: %s\n", l.getClass(), c.getClass(), b.getClass());
        Student s = new Student();
        s.setId(4356597L);
        s.setName("Nagi Ponnaganti");
        s.setAge(25);
        System.out.println("Student Hashcode: " + s.hashCode());
        s.setAge(26);
        System.out.println("Student Hashcode: " + s.hashCode());
    }

    static class Student {

        private long id;
        private String name;
        private int age;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            if (age != student.age) return false;
            return name != null ? name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
            int result = (int) (id ^ (id >>> 32));
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + age;
            return result;
        }
    }

    static abstract class Animal {
        String name = "???";

        public abstract void feed();

        public void printName() {
            System.out.println("Printing Name: " + name);
        }

        public void careFor() {
            play();
        }

        public void play() {
            System.out.println("Animal");
        }
    }

    static class Lion extends Animal {

        String name = "Leo";

        @Override
        public void feed() {
            System.out.println("Feeding Lion");
        }

        @Override
        public void printName() {
            System.out.println("Printing Name: " + name);
        }

        public void play() {
            System.out.println("lion animal");
        }

    }

    static class Cow extends Animal {

        String name = "Spa";

        @Override
        public void feed() {
            System.out.println("Feeding Cow");
        }
    }

    static class Bird extends Animal {

        @Override
        public void feed() {
            System.out.println("Feeding Bird");
        }
    }

}
