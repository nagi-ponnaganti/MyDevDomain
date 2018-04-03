package com.nagihome.beghib.ch04;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PersistingEntitiesTest {

    @Test
    public void testSaveLoad() {

        SimpleObject o1 = null;
        SimpleObject o2 = null;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            o1 = new SimpleObject();
            o1.setKey("key1");
            o1.setValue("value1");

            session.save(o1);
            tx.commit();
            Assert.assertNotNull(o1.getId());

        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            o2 = session.load(SimpleObject.class, o1.getId());
            tx.commit();
            Assert.assertTrue(o2.getKey().equals("key1"));
            Assert.assertTrue(o2.getValue().equals("value1"));

            Assert.assertTrue(o1 != o2);
        }
    }

    @Test
    public void testSaveEntitiesTwice() {

        SimpleObject so1 = null;
        Long id = null;
        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            so1 = new SimpleObject();
            so1.setKey("key2");
            so1.setValue("value2");

            session.save(so1);
            tx.commit();
            id = so1.getId();
            Assert.assertNotNull(id);

        }

        so1.setValue("value3");

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            session.save(so1);
            tx.commit();
        }

        Assert.assertFalse(so1.getId().equals(id));

        try (Session session = SessionUtil.getSession()) {

            Query q = session.createQuery("from SimpleObject so where so.key=:key");
            q.setParameter("key", "key2");
            Assert.assertTrue(q.list().size() == 2);
        }

    }

    @Test
    public void testSaveOrUpdateEntity() {

        SimpleObject simpleObject = null;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            simpleObject = new SimpleObject();
            simpleObject.setKey("key4");
            simpleObject.setValue("value4");

            session.save(simpleObject);
            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            simpleObject.setValue("value5");
            session.saveOrUpdate(simpleObject);
            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {

            Query q = session.createQuery("from SimpleObject so where so.key=:key");
            q.setParameter("key", "key4");
            Assert.assertTrue(q.list().size() == 1);
        }

    }

}
