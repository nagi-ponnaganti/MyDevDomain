package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QueueExample {

    public static void main(String[] args) throws InterruptedException {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IQueue<String> queue = hz.getQueue("queue");

        Random rand = new Random();

        while (true) {
            queue.offer(String.format(" Date: %s %s %s say Hello", LocalDateTime.now(),
                    hz.getCluster().getLocalMember(), "-"));
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            String msg = queue.poll(5, TimeUnit.SECONDS);
            if (msg != null) {
                System.err.println(msg);
            }
        }

    }

}
