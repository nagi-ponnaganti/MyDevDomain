/**
 * 
 */
package com.nagihome.hazelcast.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nagihome.hazelcast.server.main.HazelcastServer;

/**
 * @author Nagi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("App context loading ...");
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/nagihome/hazelcast/server/config/hc-server-context.xml");
		
		System.out.println("App context loaded" + context);
		
		HazelcastServer server = context.getBean(HazelcastServer.class);
		
		System.out.println("Hazelcast server: " + server);
		
		
	}

}
