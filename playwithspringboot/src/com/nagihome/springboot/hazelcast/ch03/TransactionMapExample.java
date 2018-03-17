package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.TransactionalMap;
import com.hazelcast.transaction.TransactionContext;

public class TransactionMapExample {

    public static void main(String[] args) {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();

        TransactionContext tx = hz.newTransactionContext();
        tx.beginTransaction();

        TransactionalMap<String, String> testMap = tx.getMap("testMap");
        try {
            System.err.println(testMap.get("foo"));
            Thread.sleep(30000);

            System.err.println(testMap.get("foo"));
            testMap.put("foo", "bar");
            Thread.sleep(30000);
            tx.commitTransaction();
            System.err.println("Committed!");
        } catch (Exception e) {
            tx.rollbackTransaction();
            System.err.println("Rolled Back!");
        }

    }
}
