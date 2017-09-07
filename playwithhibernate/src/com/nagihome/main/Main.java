/**
 * 
 */
package com.nagihome.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagihome.entities.Department;
import com.nagihome.entities.Employee;
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

		Department dep = new Department();
		dep.setDeptName("CSE");
		dep.setId(5);
		
		session.update(dep);
//
//		Employee emp = new Employee();
//		emp.setFirstName("Nagi Ponnaganti");
//		emp.setSalary(68000);
//		emp.setDepartment(dep);
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Yogesh");
		emp1.setSalary(50000);
		emp1.setDepartment(dep);
		
		Employee emp2 = new Employee();
		emp2.setFirstName("Aarush");
		emp2.setSalary(35000);
		emp2.setDepartment(dep);
		
		Employee emp3 = new Employee();
		emp3.setFirstName("Varsha");
		emp3.setSalary(30000);
		emp3.setDepartment(dep);
		
		Employee emp4 = new Employee();
		emp4.setFirstName("Vishal");
		emp4.setSalary(75000);
		emp4.setDepartment(dep);

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		List<Employee> result = session.createQuery("from Employee").list();
		for (Employee employee : (List<Employee>) result) {
			System.out.println(String.format("Employee %s : %s : %s",
					new Object[] { employee.getFirstName(), employee.getSalary(), employee.getDepartment() }));
		}
		session.getTransaction().commit();
		session.close();

		sessionFactory.close();
	}

}
