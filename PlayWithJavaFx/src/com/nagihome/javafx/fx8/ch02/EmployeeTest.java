package com.nagihome.javafx.fx8.ch02;

import java.beans.PropertyChangeEvent;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee e = new Employee("Nagi", 65000.0);
        e.setPropertyChangeListener(EmployeeTest::handlePropertyChangeEvent);

        e.setSalary(75000.0D);
        e.setSalary(75000.0D);
        e.setSalary(115000.0D);
    }

    private static void handlePropertyChangeEvent(PropertyChangeEvent pce) {

        System.out.printf("Property Name: %s oldValue: %s newValue: %s \n", pce.getPropertyName(), pce.getOldValue(), pce.getNewValue());
        calculateTax((double) pce.getNewValue());
    }


    private static void calculateTax(double salary) {
        System.out.println("Calculating Tax Now");
        double taxAmount = salary * (TAX_PERCENT / 100);
        System.out.printf("Salary: %s And TaxAmount: %s \n", salary, taxAmount);
    }


    private static final double TAX_PERCENT = 20D;

}
