/**
 * 
 */
package com.nagihome.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagihome.beans.Event;
import com.nagihome.util.HibernateUtil;

/**
 * @author nageswararao
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Event event01 = new Event("Our very first event!", new Date());
		event01.setDescription("This is the first event created");
		session.save(event01);
		Event event02 = new Event("Our very second event!", new Date());
		event02.setDescription("This is the second event created");
		session.save(event02);
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Event> result = session.createQuery("from Event").list();
		for (Event event : (List<Event>) result) {
			System.out.println(String.format("Event %s : %s : %s",
					new Object[] { event.getDate(), event.getTitle(), event.getDescription() }));
		}
		session.getTransaction().commit();
		session.close();

		sessionFactory.close();
	}
}
