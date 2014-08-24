/**
 * 
 */
package com.nagihome.hazelcast;

import java.util.Map;
import java.util.Queue;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @author Nagi
 *
 */
public class GettingStarted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Config config = new Config();

		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

		Map<Integer, String> mapCustomers = instance.getMap("mapCustomers");
		mapCustomers.put(1, "customer01");
		mapCustomers.put(2, "customer02");
		mapCustomers.put(3, "customer03");

		System.out.println("Map Size: " + mapCustomers.size());

		Queue<String> queueCustomers = instance.getQueue("queueCustomers");
		queueCustomers.offer("customer04");
		queueCustomers.offer("customer05");
		queueCustomers.offer("customer06");

		System.out.println("Queue Size: " + queueCustomers.size());
		
	}

}
