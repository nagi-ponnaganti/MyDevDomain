package com.nagihome.samplewebapp.temp.ch03;

import com.nagihome.samplewebapp.temp.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

public class Receipe01Test {

    @Test
    public void testNonEmbeddedOrder() throws InterruptedException {
        Session session = H2SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        NonEmbeddedOrder nonEmbeddedOrder = new NonEmbeddedOrder();
        nonEmbeddedOrder.setWeekdayRecipientName("Srinivas Guruzu");
        nonEmbeddedOrder.setWeekdayAddress("100 Main Street");
        nonEmbeddedOrder.setHolidayPhoneNumber("454-555-1212");
        nonEmbeddedOrder.setHolidayRecipientName("Joseph Ottinger");
        nonEmbeddedOrder.setHolidayAddress("P.O. Box 0");
        nonEmbeddedOrder.setHolidayPhoneNumber("978-555-1212");
        session.save(nonEmbeddedOrder);
        tx.commit();
        session.close();
    }

    @Test
    public void testRelatedContact() throws InterruptedException {
        Session session = H2SessionUtil.getSession();
        Transaction tx = session.beginTransaction();

        RelatedContact srinivas = new RelatedContact();
        srinivas.setName("Srinivas Guruzu");
        srinivas.setAddress("100 Main Street");
        srinivas.setPhone("454-555-1212");

        RelatedContact joseph = new RelatedContact();
        joseph.setName("Joseph B. Ottinger");
        joseph.setAddress("P.O. Box 0");
        joseph.setPhone("978-555-1212");

        OrderWithRelatedContact order = new OrderWithRelatedContact();
        order.setWeekdayContact(srinivas);
        order.setHolidayContact(joseph);

        session.save(order);
        tx.commit();
        session.close();
    }

    @Test
    public void testValueFromComponent() {

        Session session = H2SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        OrderWithEmbeddedContact order = new OrderWithEmbeddedContact();
        EmbeddedContact srinivas = new EmbeddedContact();
        srinivas.setName("Srinivas Guruzu");
        srinivas.setAddress("100 Main Street");
        srinivas.setPhone("454-555-1212");

        EmbeddedContact joseph = new EmbeddedContact();
        joseph.setName("Joseph B. Ottinger");
        joseph.setAddress("P.O. Box 0");

        order.setWeekDayContact(srinivas);
        order.setHolidayContact(joseph);

        session.save(order);

        tx.commit();
        session.close();

    }

}
