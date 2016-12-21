/**
 * 
 */
package com.nagihome.cxf.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nagihome.cxf.services.Order;
import com.nagihome.cxf.services.OrderProcess;

/**
 * @author nageswararao
 *
 */
public class WSClient {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "com/nagihome/cxf/client/beans-client.xml" });
		OrderProcess client = (OrderProcess) context.getBean("orderClient"); // Populate
																				// the
																				// Order
																				// bean
		Order order = new Order();
		order.setCustomerId("C001");
		order.setItemId("I001");
		order.setQty(100);
		order.setPrice(200.00);
		String orderID = client.processOrder(order);
		String message = (orderID == null) ? "Order not approved"
				: "Order approved;                             order ID is " + orderID;
		System.out.println(message);
		
		System.exit(0);
	}

}
