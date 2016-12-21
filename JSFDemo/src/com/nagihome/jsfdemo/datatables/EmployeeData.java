/**
 * 
 */
package com.nagihome.jsfdemo.datatables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author nageswararao
 *
 */
@ManagedBean(name = "employeeData", eager = true)
@SessionScoped
public class EmployeeData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String department;
	private int age;
	private double salary;

	private static final ArrayList<Employee> employees = new ArrayList<Employee>(Arrays.asList(
			new Employee("John", "Marketing", 30, 2000.00), new Employee("Robert", "Marketing", 35, 3000.00),
			new Employee("Mark", "Sales", 25, 2500.00), new Employee("Chris", "Marketing", 33, 2500.00),
			new Employee("Peter", "Customer Care", 20, 1500.00)));

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public String addEmployee() {
		Employee employee = new Employee(name, department, age, salary);
		employees.add(employee);
		return null;
	}

	public String deleteEmployee(Employee employee) {
		employees.remove(employee);
		return null;
	}

	public String editEmployee(Employee employee) {
		employee.setCanEdit(true);
		return null;
	}

	public String saveEmployees() {
		// set "canEdit" of all employees to false
		for (Employee employee : employees) {
			employee.setCanEdit(false);
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
