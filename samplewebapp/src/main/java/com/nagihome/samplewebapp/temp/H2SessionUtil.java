package com.nagihome.samplewebapp.temp;

import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.jboss.logging.Logger;

public class H2SessionUtil {
    private static final H2SessionUtil instance = new H2SessionUtil();
    private SessionFactory factory;

    Logger logger = Logger.getLogger(this.getClass());


    private H2SessionUtil() {
        try {

            Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();

            Configuration configuration =
                    new Configuration().addAnnotatedClass(com.nagihome.samplewebapp.temp.Product.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.SequenceIdEntity.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.IncrementIdEntity.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.IdentityIdEntity.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.TableIdEntity.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.MapEntry.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.StandardSqlEntity.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.DynamicSqlEntity.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.NonEmbeddedOrder.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.OrderWithRelatedContact.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.RelatedContact.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.OrderWithEmbeddedContact.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.EmbeddedContact.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.Address.class)
                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.Customer.class)
//                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.Phone.class)
//                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.Contact.class)
//                            .addAnnotatedClass(com.nagihome.samplewebapp.temp.Order.class)
                            .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                            .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
//                        .setProperty("hibernate.connection.url", "jdbc:h2:~/testdb;INIT=RUNSCRIPT FROM 'classpath:create.sql'\\;RUNSCRIPT FROM 'classpath:data.sql'")
                            .setProperty("hibernate.connection.url", "jdbc:h2:~/testdb")
                            .setProperty("hibernate.connection.username", "sa")
                            .setProperty("hibernate.connection.password", "")
                            .setProperty("hibernate.hbm2ddl.auto", "create");

            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static Session getSession() {
        return getInstance().factory.openSession();
    }

    private static H2SessionUtil getInstance() {
        return instance;
    }
}
