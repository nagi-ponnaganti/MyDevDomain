package com.nagihome.samplewebapp.temp.ch03;

import com.nagihome.samplewebapp.temp.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Receipe02Test {

    @Ignore
    public void testNestedComponents() {

        Session s = H2SessionUtil.getSession();
        Transaction t = s.beginTransaction();
        Order order = new Order();
        order.setWeekdayContact(new Contact(
                "Srinivas Guruzu",
                "100 Main Street",
                new Phone(454, 555, 1212)));
        order.setHolidayContact(new Contact(
                "Joseph Ottinger",
                "P. O. Box 0",
                new Phone(978, 555, 1212)));

        s.persist(order);
        t.commit();
        s.close();

    }

    @Test
    public void testSetComponents() {
        Session session = H2SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Customer customer = new Customer();

        Set<Address> addresses = new HashSet<Address>();

        Address secondary = new Address();
        secondary.setAddress1("100 Main Street");
        secondary.setCity("Astoria");
        secondary.setState("Portland");
        secondary.setZip("97210");

        Address primary = new Address();
        primary.setAddress1("1200 Central Ave");
        primary.setCity("Phoenix");
        primary.setState("Arizona");
        primary.setZip("85221");

        addresses.add(primary);
        addresses.add(secondary);

        customer.setAddresses(addresses);
        customer.setName("Guruzu");

        session.persist(customer);
        tx.commit();
        session.close();
    }


}
