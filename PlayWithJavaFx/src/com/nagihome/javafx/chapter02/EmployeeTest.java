/**
 * 
 */
package com.nagihome.javafx.chapter02;

import java.beans.PropertyChangeEvent;

/**
 * @author nageswararao
 *
 */
public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final Employee e1 = new Employee("Nagi Ponnaganti", 65000d);
		computeTax(e1.getSalary());		
		e1.addPropertyChangeListener(EmployeeTest::handlePropertyChange);
		
		e1.setSalary(67800d);
	}

	public static void handlePropertyChange(PropertyChangeEvent pce) {
		String propertyName = pce.getPropertyName();

		if ("salary".equals(propertyName)) {
			System.out.println("Property Value Changed");
			System.out.println("Old Value: " + pce.getOldValue());
			System.out.println("New Value: " + pce.getNewValue());
			computeTax(Double.valueOf(pce.getNewValue().toString()));
		}
	}

	public static void computeTax(double salary) {
		final double TAX_PERCENT = 20.0;
		double tax = salary * TAX_PERCENT / 100.0;
		System.out.println("Salary:" + salary + ", Tax:" + tax);
	}

}
