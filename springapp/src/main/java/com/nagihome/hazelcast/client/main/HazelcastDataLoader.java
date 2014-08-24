/**
 * 
 */
package com.nagihome.hazelcast.client.main;

import javax.annotation.PostConstruct;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * @author Nagi
 *
 */
public class HazelcastDataLoader {

	@PostConstruct
	private void init() {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("192.168.0.7:5701");

		HazelcastInstance clientInstance = HazelcastClient
				.newHazelcastClient(clientConfig);

		IMap<Integer, String> customersMap = clientInstance
				.getMap("customersMap");

		System.out.println("map size: " + customersMap.size());

		for (int i = 0; i < 20; i++) {
			System.out
					.println("Adding: " + ("Customer" + i));
			customersMap.put(i, "Customer" + i);
		}
	}

}
