/**
 * 
 */
package com.nagihome.hazelcast;

import java.util.Collection;

import com.hazelcast.config.Config;
import com.hazelcast.core.DistributedObject;
import com.hazelcast.core.DistributedObjectEvent;
import com.hazelcast.core.DistributedObjectListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @author Nagi
 *
 */
public class DistributedCacheInstanceListener implements
		DistributedObjectListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DistributedCacheInstanceListener listener = new DistributedCacheInstanceListener();

		Config config = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);

		instance.addDistributedObjectListener(listener);

		Collection<DistributedObject> distributedObjs = instance
				.getDistributedObjects();

		for (DistributedObject obj : distributedObjs) {
			System.out.println("The Instance name:" + obj.getName());
			System.out.println("The Instance service:" + obj.getServiceName());
			System.out.println("The Instance Id:" + obj.getId());
		}
	}

	@Override
	public void distributedObjectCreated(DistributedObjectEvent event) {
		System.out.println("Instance Created: " + event.getServiceName());
	}

	@Override
	public void distributedObjectDestroyed(DistributedObjectEvent event) {
		System.out.println("Instance Destroyed: " + event.getServiceName());
	}

}
