package com.nagihome.springboot.hazelcast.ch02;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleMapExample {

    public static void main(String[] args) {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        Map<String, String> capitals = hz.getMap("capitals");
        capitals.put("GB", "London");
        capitals.put("FR", "Paris");
        capitals.put("US", "Washington DC");
        capitals.put("AU", "Canberra");

        System.out.println("Capital Map Size: " + capitals.size());
        System.out.println("Capital Of GB: " + capitals.get("GB"));

        Set<String> cities = hz.getSet("cities");
        cities.add("New York");
        cities.add("London");
        cities.add("Rome");

        List<String> countries = hz.getList("countries");
        countries.addAll(capitals.keySet());
        countries.add("GB");
        countries.add("IN");

    }

}
