package com.nagihome.springboot.hazelcast.ch02;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.stream.IntStream;

public class HazelcastCustomSettings {

    public static void main(String[] args) {

        Config config = new ClasspathXmlConfig("hazelcast.xml");
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);

        Map<String, String> capitals = hz.getMap("capitals");

        IntStream.range(0, 1000).forEach(i -> {
            capitals.put("Key" + i, "Value" + i);
        });

        System.out.println("size: " + capitals.size());


    }

}
