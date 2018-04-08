package com.nagihome.beghib.ch06;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class SecondaryTableTest {

    @Test
    public void testSecondaryTables() {

        long emp1Id;
        long emp2Id;

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            Employee emp1 = new Employee();
            emp1.setFirstName("Nagi");
            emp1.setLastName("Ponnaganti");
            emp1.setEmailId("nagi.ponnaganti@gmail.com");
            emp1.setJoiningDate(new Date());
            emp1.setSalary(100000L);
            session.save(emp1);

            emp1Id = emp1.getEmployeeId();

            Employee emp2 = new Employee();
            emp2.setFirstName("Moni");
            emp2.setLastName("Gutta");
            emp2.setEmailId("moni.gutta@gmail.com");
            emp2.setJoiningDate(new Date());
            emp2.setSalary(90000L);
            session.save(emp2);

            emp2Id = emp2.getEmployeeId();

            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            Employee emp1 = session.get(Employee.class, emp1Id);
            Employee emp2 = session.get(Employee.class, emp2Id);

            Assert.assertTrue(emp1.getFirstName().equals("Nagi"));
            Assert.assertTrue(emp2.getFirstName().equals("Moni"));

            tx.commit();
        }

    }

}
