/**
 * 
 */
package com.nagihome.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * @author Nagi
 *
 */
public class GettingStartedClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("192.168.0.7:5701");

		HazelcastInstance clientInstance = HazelcastClient
				.newHazelcastClient(clientConfig);

		IMap<Integer, String> mapCustomers = clientInstance
				.getMap("mapCustomers");
		
		
		System.out.println("The customer with name: " + mapCustomers.get(1));
	}

}
