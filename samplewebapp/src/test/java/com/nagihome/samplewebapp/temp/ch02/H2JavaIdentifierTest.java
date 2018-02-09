package com.nagihome.samplewebapp.temp.ch02;

import com.nagihome.samplewebapp.temp.IdentityIdEntity;
import com.nagihome.samplewebapp.temp.IncrementIdEntity;
import com.nagihome.samplewebapp.temp.SequenceIdEntity;
import com.nagihome.samplewebapp.temp.TableIdEntity;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class H2JavaIdentifierTest {

    private SessionFactory sessionFactory;

    @BeforeClass
    public void init() throws SQLException {
        Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();

        Configuration configuration =
                new Configuration().addAnnotatedClass(com.nagihome.samplewebapp.temp.Product.class)
                        .addAnnotatedClass(com.nagihome.samplewebapp.temp.SequenceIdEntity.class)
                        .addAnnotatedClass(com.nagihome.samplewebapp.temp.IncrementIdEntity.class)
                        .addAnnotatedClass(com.nagihome.samplewebapp.temp.IdentityIdEntity.class)
                        .addAnnotatedClass(com.nagihome.samplewebapp.temp.TableIdEntity.class)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                        .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
//                        .setProperty("hibernate.connection.url", "jdbc:h2:~/testdb;INIT=RUNSCRIPT FROM 'classpath:create.sql'\\;RUNSCRIPT FROM 'classpath:data.sql'")
                        .setProperty("hibernate.connection.url", "jdbc:h2:~/testdb")
                        .setProperty("hibernate.connection.username", "sa")
                        .setProperty("hibernate.connection.password", "")
                        .setProperty("hibernate.hbm2ddl.auto", "create");

        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Test
    public void testGeneratorSequence() {
        final Session session1 = sessionFactory.openSession();
        Transaction tx = session1.beginTransaction();
        IntStream.rangeClosed(0, 10).forEach(i -> {
            SequenceIdEntity sequenceIdEntity = new SequenceIdEntity();
            sequenceIdEntity.setField("value" + i);
            session1.persist(sequenceIdEntity);
        });
        tx.commit();
        session1.close();

        final Session session2 = sessionFactory.openSession();
        tx = session2.beginTransaction();
        List<SequenceIdEntity> sequenceIdEntities = session2.createQuery("from SequenceIdEntity").list();
        Assert.assertEquals(sequenceIdEntities.stream().collect(Collectors.maxBy(Comparator.comparing(SequenceIdEntity::getId))).get().getId(), 14);
        tx.commit();
        session2.close();
    }


    @Test
    public void testIncrementSequence() {
        Session session1 = sessionFactory.openSession();
        Transaction tx = session1.beginTransaction();
        IntStream.range(1, 22).forEach(i -> {
            IncrementIdEntity id = new IncrementIdEntity();
            id.setField("Value" + i);
            session1.persist(id);
        });

        tx.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        tx = session2.beginTransaction();
        List<IncrementIdEntity> incrementIdEntities = session2.createQuery("from IncrementIdEntity").list();
        Assert.assertEquals(incrementIdEntities.stream().collect(Collectors.maxBy(Comparator.comparing(IncrementIdEntity::getId))).get().getId(), 21);
        tx.commit();
        session2.close();
    }

    @Test
    public void testIdentitySequence() {
        Session session1 = sessionFactory.openSession();
        Transaction tx = session1.beginTransaction();
//        IdentityIdEntity id1 = new IdentityIdEntity();
//        id1.setId(1);
//        id1.setValue("value1");
//        session1.persist(id1);

        IntStream.range(1, 12).forEach(i -> {
            IdentityIdEntity id = new IdentityIdEntity();
            id.setValue("value" + i);
            System.out.println("persisting: " + id);
            session1.persist(id);
        });
        tx.commit();
        session1.close();

        Session session2 = sessionFactory.openSession();
        tx = session2.beginTransaction();
        List<IdentityIdEntity> list = session2.createQuery("from IdentityIdEntity").list();
        Assert.assertEquals(list.stream().collect(Collectors.maxBy(Comparator.comparing(IdentityIdEntity::getId))).get().getId(), 11);
        tx.commit();
        session2.close();
    }

    @Test
    public void testTableGenerator() {
        Session s1 = sessionFactory.openSession();
        Transaction tx = s1.beginTransaction();
        IntStream.range(1, 22).forEach(i -> {
            TableIdEntity id = new TableIdEntity();
            id.setValue("value" + i);
            s1.persist(id);
        });
        tx.commit();
        s1.close();

        Session s2 = sessionFactory.openSession();
        tx = s2.beginTransaction();
        List<TableIdEntity> list = s2.createQuery("from TableIdEntity").list();
        Assert.assertEquals(list.stream().collect(Collectors.maxBy(Comparator.comparing(TableIdEntity::getId))).get().getId(), 21);
        tx.commit();
        s2.close();
    }

}
