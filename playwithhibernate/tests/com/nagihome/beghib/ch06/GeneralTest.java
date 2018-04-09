package com.nagihome.beghib.ch06;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GeneralTest {

    @Test
    public void testTransient() {

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            TransientObject obj = new TransientObject();
            obj.setImpField("Imp Field");
            obj.setNonImpField("Non Imp Field");

            session.save(obj);

            tx.commit();
        }
    }

    @Test
    public void testEmbedded() {

        Long id;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            Location location = new Location();
            location.setCity("London");
            location.setCountry("UK");

            Publisher eBookPublisher = new Publisher();
            eBookPublisher.setLocation(location);
            eBookPublisher.setName("Ebook Publisher");

            Publisher paperBackPublisher = new Publisher();
            paperBackPublisher.setLocation(location);
            paperBackPublisher.setName("PaperBack Publisher");

            Book book = new Book();
            book.setEbookPublisher(eBookPublisher);
            book.setPaperBackPublisher(paperBackPublisher);

            book.setAuthor("Nagi");
            book.setTitle("This is Hibernate");

            session.save(book);

            id = book.getId();

            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            Book book = session.load(Book.class, id);
            tx.commit();
            Assert.assertTrue(book.getEbookPublisher().getLocation().getCity().equals("London"));
            Assert.assertTrue(book.getPaperBackPublisher().getLocation().getCity().equals("London"));

        }
    }

    @Test
    public void testManyToOne() {

        Long id;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            Person person = new Person();
            person.setName("Nagi");

            session.save(person);

            Phone phone1 = new Phone();
            phone1.setPhoneNumber("07507260541");
            phone1.setPerson(person);

            session.save(phone1);

            Phone phone2 = new Phone();
            phone2.setPhoneNumber("07507260542");
            phone2.setPerson(person);

            session.save(phone2);

            id = person.getId();

            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from Phone p");
            List<Phone> phones = query.list();

            phones.forEach(System.out::println);
        }
    }

}
