package com.nagihome.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;


public class HashSetTest {

    private Set<String> set;

    @Before
    public void init() {
        set = new HashSet<>();
    }

    @Test
    public void testConstructors() {
         assertTrue(set.size() == 0);
         set = new HashSet<>(Stream.of("Nagi", "Ponnaganti").collect(Collectors.toList()));
         assertTrue(set.size() == 2);
         assertTrue(set.contains("Nagi"));

         set = new HashSet<>(20);
         set = new HashSet<>(20, 0.80f);
    }

    @Test
    public void testAdd() {
        set.add("Nagi");
        set.add("Ponnaganti");
        set.add("Ponnaganti");
        assertTrue(set.size() == 2);

        Set<Person> people = new HashSet<>();

        people.add(new Person("Nagi"));
        people.add(new Person("Ponnaganti"));

        people.stream().filter(p -> p.getName() == "Ponnaganti").forEach(p -> p.setName("Nagi"));
        System.out.println(people);

        Set<Person> people1 = new HashSet<>();

        people1.addAll(people);

        System.out.println(people1);

    }

    class Person {
        public Person(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testIterator() {
        set.add("Message1");
        set.add("Message2");
        set.add("Message3");
        set.add("Message4");

        Iterator<String> it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
            it.remove();
            System.out.println(set);
        }

        set.add("Message1");
        set.add("Message2");
        set.add("Message3");
        set.add("Message4");

        Spliterator<String> spliterator = set.spliterator();
        System.out.println(spliterator.characteristics());

    }


}
