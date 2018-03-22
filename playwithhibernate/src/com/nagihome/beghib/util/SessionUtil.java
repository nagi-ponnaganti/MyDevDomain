package com.nagihome.beghib.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class SessionUtil {

    private static final SessionUtil instance = new SessionUtil();
    private static final String CONFIG_NAME = "/configuration.properties";
    private final SessionFactory factory;
    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    private SessionUtil() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("/com/nagihome/beghib/hibernate.cfg.xml")
                .build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static Session getSession() {
        return getInstance().factory.openSession();
    }

    private static SessionUtil getInstance() {
        return instance;
    }

    public static void doWithSession(Consumer<Session> command) {
        try (Session session = getSession()) {
            Transaction tx = session.beginTransaction();

            command.accept(session);
            if (tx.isActive() &&
                    !tx.getRollbackOnly()) {
                tx.commit();
            } else {
                tx.rollback();
            }
        }
    }

}
