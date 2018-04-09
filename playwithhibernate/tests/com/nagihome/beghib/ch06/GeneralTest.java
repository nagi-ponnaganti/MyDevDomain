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

            Assert.assertTrue(phones.size() == 2);
        }
    }


    @Test
    public void testOneToMany() {

        Long id;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            Phone1 phone1 = new Phone1();
            phone1.setPhoneNum("12345");
            Phone1 phone2 = new Phone1();
            phone2.setPhoneNum("67890");

            session.save(phone1);
            session.save(phone2);

            Person1 person1 = new Person1();
            person1.getPhones().add(phone1);
            person1.getPhones().add(phone2);

            session.save(person1);

            tx.commit();

            id = person1.getId();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Person1 person1 = session.load(Person1.class, id);
            Assert.assertTrue(person1.getPhones().size() == 2);
        }
    }

    @Test
    public void testOneToManyBiDirectional() {
        Long id;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            Person2 person1 = new Person2();
            person1.setName("Nagi");
            session.save(person1);

            Phone2 phone1 = new Phone2();
            phone1.setPhoneNum("12345");
            phone1.setPerson(person1);
            Phone2 phone2 = new Phone2();
            phone2.setPhoneNum("67890");
            phone2.setPerson(person1);

            session.save(phone1);
            session.save(phone2);

            tx.commit();

            id = person1.getId();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Person2 person1 = session.load(Person2.class, id);
            Assert.assertTrue(person1.getPhones().size() == 2);
        }
    }

    @Test
    public void testOneToOneUniDirectional() {

        Long id;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            PhoneDetails phoneDetails = new PhoneDetails();
            phoneDetails.setProvider("O2");
            session.save(phoneDetails);

            Phone3 phone3 = new Phone3();
            phone3.setPhoneNum("07507260541");
            phone3.setPhoneDetails(phoneDetails);
            session.save(phone3);

            id = phone3.getId();

            tx.commit();

        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            Phone3 phone3 = session.get(Phone3.class, id);

            Assert.assertTrue(phone3.getPhoneDetails().getProvider().equals("O2"));
            tx.commit();
        }
    }


    @Test
    public void testOneToOneBiDirectional() {

        Long pId;
        Long pdId;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            Phone4 phone4 = new Phone4();
            phone4.setPhoneNum("07507260541");
            session.save(phone4);


            PhoneDetails4 phoneDetails4 = new PhoneDetails4();
            phoneDetails4.setProvider("O2");
            phoneDetails4.setPhone4(phone4);
            session.save(phoneDetails4);

            pId = phone4.getId();
            pdId = phoneDetails4.getId();

            tx.commit();

        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            Phone4 phone4 = session.get(Phone4.class, pId);

            Assert.assertTrue(phone4.getPhoneDetails4().getProvider().equals("O2"));

            PhoneDetails4 phoneDetails4 = session.get(PhoneDetails4.class, pdId);
            Assert.assertTrue(phoneDetails4.getPhone4().getPhoneNum().equals("07507260541"));

            tx.commit();
        }
    }

}