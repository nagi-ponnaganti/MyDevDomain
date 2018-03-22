package com.nagihome.beghib.ch01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PersistenceTest {

    private SessionFactory sessionFactory = null;

    @BeforeClass
    public void setUp() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("/com/nagihome/beghib/hibernate.cfg.xml")
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void saveMessage() {
        Message message = new Message();
        message.setText("Hello World!!!!");

        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(message);
            tx.commit();
        }
    }

    @Test(dependsOnMethods = "saveMessage")
    public void readMessage() {

        try (Session session = sessionFactory.openSession()) {
            List<Message> messages = session.createQuery("from Message", Message.class).list();
            assertEquals(1, messages.size());

            messages.forEach(System.out::println);
        }
    }

}
