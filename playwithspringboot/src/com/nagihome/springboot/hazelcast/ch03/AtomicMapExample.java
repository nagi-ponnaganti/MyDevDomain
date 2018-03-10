package com.nagihome.springboot.hazelcast.ch03;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class AtomicMapExample {

    public static void main(String[] args) {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IMap<String, String> capitals = hz.getMap("capitals");
        capitals.put("GB","Winchester");
        System.err.println("Capital Of GB(Until 1066): " + capitals.get("GB"));

        String actualCapital = capitals.putIfAbsent("GB", "London");
        System.err.println("failed to putIfAbsent capital for GB: " + actualCapital);

        boolean r1 = capitals.replace("GB", "Southampton", "London");
        System.err.printf("Failed to replace: %s and the capital as of now is: %s \n", !r1, capitals.get("GB"));

        boolean r2 = capitals.replace("GB", "Winchester", "London");
        System.err.printf("Success to replace: %s and the capital as of now is: %s \n", r2, capitals.get("GB"));
    }
}
