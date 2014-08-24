/**
 * 
 */
package com.nagihome.hazelcast.server.main;

import java.util.Map;

import javax.annotation.PostConstruct;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @author Nagi
 *
 */
public class HazelcastServer {

	private Map<Integer, String> customersMap;

	@PostConstruct
	private void init() {

		System.out.println("***Creating new instance***");
		
		HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		
		System.out.println("Instance Created and Name is: "
				+ instance.getName());
		
		System.out.println("getting customer map");
		customersMap = instance.getMap("customersMap");
		
		System.out.println("customer map of size: " + customersMap.size());
		
	}

}
