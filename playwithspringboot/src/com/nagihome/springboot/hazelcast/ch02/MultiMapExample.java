package com.nagihome.springboot.hazelcast.ch02;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;

public class MultiMapExample {

    public static void main(String[] args) {

        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        MultiMap<String, String> multiMap = hz.getMultiMap("countriesWithCities");
        multiMap.put("GB", "London");
        multiMap.put("GB", "Birmingham");
        multiMap.put("GB", "Manchester");
        multiMap.put("FR", "Paris");

        System.out.println("GB Cities: " + multiMap.get("GB"));
        System.out.println("FR Cities: " + multiMap.get("FR"));


    }

}
