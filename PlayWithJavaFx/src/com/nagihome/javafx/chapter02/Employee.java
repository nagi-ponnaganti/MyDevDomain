package com.nagihome.javafx.chapter02;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Employee {
	
	private String name;
	private double salary;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);	

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		PropertyChangeEvent pce = new PropertyChangeEvent(this, "salary", this.salary, salary);
		this.salary = salary;
		pcs.firePropertyChange(pce);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}
	
	
}
