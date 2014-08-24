/**
 * 
 */
package com.nagihome.hazelcast;

import java.util.Map;
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

		System.out.println("Map Size: " + mapCustomers.size());

	}

}
