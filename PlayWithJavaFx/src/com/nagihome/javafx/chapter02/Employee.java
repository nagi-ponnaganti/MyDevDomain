package com.nagihome.javafx.chapter02;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Employee {

	private String name;
	private double salary;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Employee() {
		this.name = "Nagi Ponnaganti";
		this.salary = 1000.0;
	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double newSalary) {
		double oldSalary = this.salary;
		this.salary = newSalary;
		pcs.firePropertyChange("salary", oldSalary, newSalary);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}

	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", salary=" + salary +
				", pcs=" + pcs +
				'}';
	}
}
