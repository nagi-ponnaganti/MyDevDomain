package com.nagihome.beghib.ch06;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}
