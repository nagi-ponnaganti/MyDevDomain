/**
 * 
 */
package com.nagihome.types;

import java.net.URL;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	public static void main(String[] args) throws Exception {
		SessionFactory factory = HibernateUtil.getInstance().getSessionFactory();

		Session session = factory.openSession();

		session.beginTransaction();

		Contact contact01 = new Contact();
		Name name = new Name();
		name.setFirstName("Nagi");
		name.setLastName("Ponnaganti");
		contact01.setName("Nagi Ponnaganti");
		contact01.setNotes("This Is My First Contact");
		contact01.setStarred(true);
		contact01.setWebsite(new URL("http://www.google.com"));

		session.save(contact01);
		session.getTransaction().commit();
		session.close();

		session = factory.openSession();

		session.beginTransaction();

		Contact contact02 = (Contact) session.createQuery("from Contact").list().get(0);

		System.out.println("Contact Data: " + ToStringBuilder.reflectionToString(contact02));
		session.close();

		factory.close();
	}

}
