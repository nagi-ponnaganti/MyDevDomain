package com.nagihome.samplewebapp.temp.ch02.r0;


import com.nagihome.samplewebapp.temp.Product;
import com.nagihome.samplewebapp.temp.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Recipe00Test {

    @Test
    public void testCreate() {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Product p1 = new Product();
        p1.setSku(1234L);
        p1.setTitle("XBox");
        p1.setDescription("Gaming");
        session.persist(p1);
        tx.commit();
        session.close();

        session = SessionUtil.getSession();
        tx = session.beginTransaction();
        Product p2 = session.load(Product.class, 1234L);
        assertEquals(p1.getTitle(), p2.getTitle());
        tx.commit();
        session.close();
    }

    @BeforeMethod
    public void clearData() {
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        clearAll(session, "from Product p");
        session.getTransaction().commit();
        session.close();
    }

    private void clearAll(Session session, String constraint) {
        Query query = session.createQuery("delete " + constraint);
        query.executeUpdate();
    }

}
