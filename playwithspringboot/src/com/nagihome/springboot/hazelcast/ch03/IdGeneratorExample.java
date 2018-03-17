package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class IdGeneratorExample {

    public static void main(String[] args) {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();

        IdGenerator idGenerator = hz.getIdGenerator("newId");

        IntStream.rangeClosed(0, 5).forEach(
                i -> {
                    System.out.printf("hz Instance: %s counter: %s \n", hz.getCluster().getLocalMember(), idGenerator.newId());
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
