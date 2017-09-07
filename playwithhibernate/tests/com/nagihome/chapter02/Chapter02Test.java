package com.nagihome.chapter02;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.nagihome.entities.Employee;
import com.nagihome.util.HibernateUtil;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class Chapter02Test {

	@Test
	public void testSessionGet() {

		Session session = getSession();
		Employee employee = session.get(Employee.class, 4l);
		session.close();

		assertEquals("This User is Nagi", "Nagi", employee.getFirstName());

	}

	@Test
	public void testSessionLoadWithGet() {

		Session session = getSession();
		Employee employee = session.get(Employee.class, 4l);

		assertEquals("This User is Nagi", "Nagi", employee.getFirstName());

		Employee employee1 = session.load(Employee.class, 4l);

		assertEquals("This User is Nagi", "Nagi", employee1.getFirstName());

	}

	@Test
	public void testSessionLoad() {

		Session session = getSession();

		Employee employee1 = session.load(Employee.class, 4l);

		session.close();

		assertEquals("This User is Nagi", "Nagi", employee1.getFirstName());

	}

	@Ignore
	@Test
	public void testSessionDelete() {
		Session session = getSession();

		session.beginTransaction();
		Employee emp = session.get(Employee.class, 6l);
		session.delete(emp);
		session.getTransaction().commit();

		Employee emp1 = session.get(Employee.class, 6l);

		session.close();

		assertNull(emp1);

	}

	@Test
	public void testSessionUpdate() {

		Session session = getSession();

		session.beginTransaction();

		Employee emp = session.get(Employee.class, 4L);
		emp.setSalary(70001);
		emp.setFirstName("Nagi");
		session.update(emp);

		session.getTransaction().commit();
		assertEquals(70001L, emp.getSalary(), 1L);

		session.close();

	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSessionCriteria() {
		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);
		c.add(Restrictions.gt("salary", 35000D));

		c.list().forEach(e -> System.out.println(e.toString()));

		s.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSessionPagination() {
		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);

		c.setFirstResult(1);
		c.setMaxResults(4);

		c.list().forEach(e -> System.out.println(e.toString()));

		assertEquals("Count has to be 4", c.list().size(), 4);
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSessionOrderBy() {

		System.out.println("Test Session Order By");

		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);
		c.addOrder(Order.desc("id"));

		c.list().forEach(e -> System.out.println(e.toString()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSessionListTrans() {

		System.out.println("Test Session Trans List");

		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);
		c.setResultTransformer(Transformers.TO_LIST);
		c.list().forEach(e -> System.out.println(e.toString()));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSessionMapTrans() {

		System.out.println("Test Session Trans Map");

		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);
		c.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		c.list().forEach(e -> System.out.println(e.toString()));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSessionProjections() {
		System.out.println("Test Session Projections");

		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);
		c.setProjection(Projections.property("id"));
		c.list().forEach(e -> System.out.print(e.toString() + ","));

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSessionCriteriaProj() {

		System.out.println("Test Session Criteria Projections");

		Session s = getSession();
		Criteria c = s.createCriteria(Employee.class);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.alias(Projections.property("id"), "empId"));
		proList.add(Projections.alias(Projections.property("firstName"), "empFirstName"));
		c.setProjection(proList);
		c.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		c.list().forEach(e -> System.out.print(e.toString() + ","));

	}

	private Session getSession() {
		return sessionFactory.openSession();
	}

	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void init() throws Exception {
		System.out.println("init method started");

		System.out.println("init sessionfactory");
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();

		System.out.println("init method completed");

	}
}
