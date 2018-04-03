package com.nagihome.beghib.ch04;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeRefreshTest {

    @Test
    public void testMergeOperation() {

        SimpleObject so = null;

        try (Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            so = new SimpleObject();
            so.setKey("key1");
            so.setValue("value1");

            session.save(so);

            tx.commit();
        }

        validateObject(so.getId(), so.getValue());


        so.setValue("value2");

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(so);
        tx.commit();
        session.close();

        validateObject(so.getId(), so.getValue());

    }

    @Test
    public void testRefreshOperation() {

        SimpleObject so = null;
        try(Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();

            so = new SimpleObject();
            so.setKey("key3");
            so.setValue("value3");

            session.save(so);
            tx.commit();
        }

        validateObject(so.getId(), so.getValue());

        so.setValue("value4");

        try(Session session = SessionUtil.getSession()) {
            session.refresh(so);
        }

        validateObject(so.getId(), so.getValue());

    }

    private void validateObject(Long id, String value) {

        try (Session session = SessionUtil.getSession()) {
            SimpleObject so = session.get(SimpleObject.class, id);
            Assert.assertTrue(so.getValue().equals(value));
        }
    }

}
