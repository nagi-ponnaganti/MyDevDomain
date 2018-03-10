package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class LockingExample {

    public static void main(String[] args) throws InterruptedException {

        LockingExample le = new LockingExample();

        HazelcastInstance hz1 = Hazelcast.newHazelcastInstance();
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance();
        HazelcastInstance hz3 = Hazelcast.newHazelcastInstance();
        HazelcastInstance hz4 = Hazelcast.newHazelcastInstance();

        ExecutorService es = Executors.newCachedThreadPool();

        es.submit(() -> {le.doSomeWork(hz1);});
        es.submit(() -> {le.doSomeWork(hz2);});
        es.submit(() -> {le.doSomeWork(hz3);});
        es.submit(() -> {le.doSomeWork(hz4);});

        es.shutdown();
    }


    private void doSomeWork(HazelcastInstance hz) {
        Lock lock = hz.getLock("lock");

        lock.lock();
        System.out.printf("Im doing some work: %s %s \n", hz.getCluster().getLocalMember(), LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.printf("Im completed work: %s %s \n", hz.getCluster().getLocalMember(), LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
