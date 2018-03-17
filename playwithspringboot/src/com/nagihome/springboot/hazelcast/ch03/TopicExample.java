package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import java.util.Date;

public class TopicExample {
    public static void main(String[] args) throws Exception {
        HazelcastInstance
                hz = Hazelcast.newHazelcastInstance();
        ITopic<String> broadcastTopic = hz.getTopic("broadcast");
        broadcastTopic.addMessageListener(new TopicListener());
        while (true) {
            broadcastTopic.publish(new Date() + " - " + hz.getCluster().getLocalMember() + " says hello");
            Thread.sleep(1000);
        }
    }
}