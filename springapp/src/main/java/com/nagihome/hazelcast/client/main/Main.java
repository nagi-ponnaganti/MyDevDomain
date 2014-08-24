/**
 * 
 */
package com.nagihome.hazelcast.client.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Nagi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/nagihome/hazelcast/client/config/hc-dataloader-context.xml");
		
		System.out.println("client config loaded");
	}

}
