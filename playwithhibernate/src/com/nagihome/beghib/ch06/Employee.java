package com.nagihome.beghib.ch06;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
@SecondaryTable(name = "EMPLOYEE_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMPLOYEE_ID"))
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ID", table = "EMPLOYEE_DETAILS")
    private String emailId;
    @Column(name = "JOINING_DATE", table = "EMPLOYEE_DETAILS")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    @Column(name = "SALARY", table = "EMPLOYEE_DETAILS")
    private double salary;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", joiningDate=" + joiningDate +
                ", salary=" + salary +
                '}';
    }
}
