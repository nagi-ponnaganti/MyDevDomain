package com.nagihome.beghib.ch06;


import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompoundKeyTest {

    @Test
    public void testEmbeddable() {

        CPKBook book1 = null;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            ISBN isbn = new ISBN();
            isbn.setCheckdigit(4);
            isbn.setGroupName(4);
            isbn.setPublisher(53674);
            isbn.setTitle(9876);
            book1 = new CPKBook();
            book1.setId(isbn);
            book1.setName("Hibernate Beginning");

            session.save(book1);

            tx.commit();

        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            ISBN isbn = new ISBN();
            isbn.setCheckdigit(4);
            isbn.setGroupName(4);
            isbn.setPublisher(53674);
            isbn.setTitle(9876);

            CPKBook book2 = session.get(CPKBook.class, isbn);
            System.out.println(book2);
            tx.commit();

            Assert.assertTrue(book1.getId().equals(book2.getId()));

        }
    }
}
