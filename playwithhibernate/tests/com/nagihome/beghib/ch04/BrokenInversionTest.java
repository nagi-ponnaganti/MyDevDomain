package com.nagihome.beghib.ch04;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenInversionTest {

    @Test
    public void testProperSimpleInversionCode() {
        Long emailId;
        Long messageId;
        Email1 email1;
        Message1 message1;

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            email1 = new Email1("email1");
            message1 = new Message1("message1");
            email1.setMessage1(message1);
            message1.setEmail1(email1);

            session.save(email1);
            session.save(message1);

            emailId = email1.getId();
            messageId = message1.getId();

            tx.commit();
        }

        Assert.assertNotNull(emailId);
        Assert.assertNotNull(messageId);

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Assert.assertNotNull(session.get(Email1.class, emailId).getMessage1());
            Assert.assertNotNull(session.get(Message1.class, messageId).getEmail1());
            tx.commit();
        }
    }

    @Test
    public void testBrokenInversionCode() {

        Email1 email1;
        Message1 message1;
        Long emailId;
        Long messageId;

        try(Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            email1 = new Email1("email1");
            message1 = new Message1("message1");
            email1.setMessage1(message1);
//            message1.setEmail1(email1);

            session.save(email1);
            session.save(message1);

            emailId = email1.getId();
            messageId = message1.getId();

            Assert.assertNotNull(emailId);
            Assert.assertNotNull(messageId);

            tx.commit();
        }


        try(Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            Assert.assertNotNull(session.get(Email1.class, emailId).getMessage1());
            Assert.assertNull(session.get(Message1.class, messageId).getEmail1());
            tx.commit();
        }

    }

}
