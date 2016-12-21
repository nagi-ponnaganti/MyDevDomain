/**
 * 
 */
package com.nagihome.beghib.chapter01;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nagihome.util.HibernateUtil;

/**
 * @author nageswararao
 *
 */
public class Chapter01Test {

	private static SessionFactory sessionFactory;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSaveMessage() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (int i = 0; i < 1000; i++) {
			Message message01 = new Message();
			message01.setText("Message Number " + (i + 1));
			session.save(message01);
		}

		List<Message> messages = session.createQuery("from Message").list();

		for (Message message : messages) {
			System.out.println("Message is: " + ToStringBuilder.reflectionToString(message));
		}

		session.close();
	}

}
