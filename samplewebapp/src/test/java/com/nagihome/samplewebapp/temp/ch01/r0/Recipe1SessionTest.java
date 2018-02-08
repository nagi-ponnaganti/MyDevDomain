package com.nagihome.samplewebapp.temp.ch01.r0;

import com.nagihome.samplewebapp.temp.Book;
import com.nagihome.samplewebapp.temp.Publisher;
import com.nagihome.samplewebapp.temp.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Date;

import static org.testng.Assert.*;


public class Recipe1SessionTest {

    @Test
    public void testCreate() {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Publisher publisher = new Publisher();
        publisher.setCode("apress");
        publisher.setName("Apress");
        publisher.setAddress("233 Spring Street, New York, NY 10013");
        session.persist(publisher);
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Publisher pub1 = session.load(Publisher.class, "apress");
        assertEquals(pub1.getName(), "Apress");
        tx.commit();
        session.close();
    }

    @Test
    public void testCreateObjectGraph() {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Publisher publisher = new Publisher();
        publisher.setCode("apress");
        publisher.setName("Apress");
        publisher.setAddress("233 Spring Street, New York, NY 10013");

        Book book = new Book();
        book.setIsbn("9781484201282");
        book.setName("Hibernate Recipes1");
        book.setPrice(new BigDecimal("44.00"));
        book.setPublishdate(Date.valueOf("2014-10-10"));
        book.setPublisher(publisher);

        session.persist(book);

        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Book book1 = session.load(Book.class, "9781484201282");
        assertNotNull(book1);
        assertNotNull(book1.getPublisher());
        assertEquals(book.getName(), book1.getName());
        assertEquals(book.getPublisher(), book1.getPublisher());
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();

        session.refresh(publisher);

        Book book2 = new Book();
        book2.setIsbn("9781430265177");
        book2.setName("Hibernate Recipes2");
        book2.setPrice(new BigDecimal("44.00"));
        book2.setPublishdate(Date.valueOf("2014-10-04"));
        book2.setPublisher(publisher);

        session.persist(book2);
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        book1 = session.get(Book.class, "9781430265177");
        assertNotNull(book.getPublisher());
        assertEquals(book.getPublisher().getName(), publisher.getName());
        tx.commit();
        session.close();

    }

    @Test
    public void testUpdate() {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Publisher publisher = new Publisher();
        publisher.setCode("apress");
        publisher.setName("Apress");
        publisher.setAddress("233 Spring Street, New York, NY 10013");
        session.persist(publisher);
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Publisher publisher1 = session.load(Publisher.class, "apress");
        publisher1.setName("Apress Publishing");
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Publisher publisher2 = session.load(Publisher.class, "apress");
        assertEquals(publisher1.getName(), publisher2.getName());
        tx.commit();
        session.close();
    }

    @Test
    public void testUpdateDetachedObject() {

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Publisher pub = new Publisher();
        pub.setName("Apress");
        pub.setCode("apress");
        pub.setAddress("Newyork, USA");
        session.persist(pub);
        assertTrue(session.contains(pub));
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        assertFalse(session.contains(pub));
        pub.setName("Apress Publishing");
        session.merge(pub);
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Publisher pub2 = session.load(Publisher.class, "apress");
        assertEquals(pub2.getName(), pub.getName());
        tx.commit();
        session.close();
    }

    @Test
    public void testDelete() {

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Publisher pub1 = new Publisher();
        pub1.setCode("apress");
        pub1.setName("Apress");
        pub1.setAddress("New York, USA");
        session.persist(pub1);
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Publisher pub2 = session.load(Publisher.class, "apress");
        session.delete(pub2);
        assertEquals(pub1.getName(), pub2.getName());
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Publisher pub = session.get(Publisher.class, "apress");
        assertNull(pub);
        tx.commit();
        session.close();
    }

    @BeforeMethod
    public void clearData() {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        clearAll(session, "from Book b");
        clearAll(session, "from Publisher p");
        tx.commit();
    }

    /**
     * Clear All Data
     *
     * @param session
     * @param contraint
     */
    private void clearAll(Session session, String contraint) {
        Query query = session.createQuery("delete " + contraint);
        query.executeUpdate();
    }
}
