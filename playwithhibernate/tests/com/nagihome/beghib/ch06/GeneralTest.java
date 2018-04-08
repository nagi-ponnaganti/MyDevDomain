package com.nagihome.beghib.ch06;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

public class GeneralTest {

    @Test
    public void testTransient() {

        try(Session session = SessionUtil.getSession()) {

            Transaction tx = session.beginTransaction();
            TransientObject obj = new TransientObject();
            obj.setImpField("Imp Field");
            obj.setNonImpField("Non Imp Field");

            session.save(obj);

            tx.commit();
        }
    }

}
