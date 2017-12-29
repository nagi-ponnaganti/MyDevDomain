/**
 *
 */
package com.nagihome.javafx.chapter02;

import java.beans.PropertyChangeEvent;

/**
 * @author nageswararao
 */
public class EmployeeTest {

    public static void main(String[] args) {
        Employee e1 = new Employee("Moni", 2000.0);
        e1.addPropertyChangeListener(EmployeeTest::handlePropertyChange);
        e1.setSalary(2000.0);
        e1.setSalary(3000.0);
        e1.setSalary(4000.0);
    }

    private static void handlePropertyChange(PropertyChangeEvent pce) {
        String propertyName = pce.getPropertyName();
        if("salary".equalsIgnoreCase(propertyName)) {
            System.out.printf("Salary has changed. \n");
            System.out.printf("Old: %s, New: %s\n", pce.getOldValue(), pce.getNewValue());
            computeTax((Double) pce.getNewValue());
        }
    }

    private static void computeTax(double salary) {
        double TAX_PERCENTAGE = 20.0;
        double tax = salary * TAX_PERCENTAGE / 100;
        System.out.printf("Salary: %s, Tax: %s\n", salary, tax);
    }
}
