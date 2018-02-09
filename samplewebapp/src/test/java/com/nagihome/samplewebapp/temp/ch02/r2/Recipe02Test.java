package com.nagihome.samplewebapp.temp.ch02.r2;

import com.nagihome.samplewebapp.temp.DynamicSqlEntity;
import com.nagihome.samplewebapp.temp.H2SessionUtil;
import com.nagihome.samplewebapp.temp.MapEntry;
import com.nagihome.samplewebapp.temp.StandardSqlEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Recipe02Test {

    @Test
    public void testSaveOrUpdate() {
        Session s1 = H2SessionUtil.getSession();
        Transaction tx = s1.beginTransaction();
        MapEntry m1 = new MapEntry();
        m1.setValue1("Value1");
        m1.setKey1(1);
        s1.saveOrUpdate(m1);
        tx.commit();
        s1.close();

        s1 = H2SessionUtil.getSession();
        tx = s1.beginTransaction();
        m1 = new MapEntry();
        m1.setValue1("Value2");
        m1.setKey1(1);
        s1.saveOrUpdate(m1);
        tx.commit();
        s1.close();

        s1 = H2SessionUtil.getSession();
        tx = s1.beginTransaction();
        MapEntry m2 = s1.load(MapEntry.class, 1);
        Assert.assertEquals(m1.getValue1(), "Value2");
    }

    @Test
    public void testStandardSqlEntity() {

        Session s1 = H2SessionUtil.getSession();
        Transaction tx = s1.beginTransaction();
        StandardSqlEntity e = new StandardSqlEntity();
        e.setField1("Value1");
        s1.persist(e);
        tx.commit();
        s1.close();
    }

    @Test
    public void testDynamicSqlEntity() {
        Session s1 = H2SessionUtil.getSession();
        Transaction tx = s1.beginTransaction();
        DynamicSqlEntity e = new DynamicSqlEntity();
        e.setField1("Value1");
        s1.persist(e);
        tx.commit();
        s1.close();
    }


}
