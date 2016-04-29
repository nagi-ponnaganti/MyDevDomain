/**
 * 
 */
package com.nagihome.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author nageswararao
 *
 */
public class HibernateUtil {

	private static HibernateUtil instance;
	
	private SessionFactory sessionFactory;

	private HibernateUtil() throws Exception {
		System.out.println("Initilizing the Hibernate Session Factory");

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("com/nagihome/config/hibernate.cfg.xml").build();

		try {

			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.err.println(ex.getMessage());
			throw new Exception(ex);
		}
	}

	/**
	 * @return the instance
	 * @throws Exception 
	 */
	public static HibernateUtil getInstance() throws Exception {

		if (instance == null) {
			instance = new HibernateUtil();
		}

		return instance;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
