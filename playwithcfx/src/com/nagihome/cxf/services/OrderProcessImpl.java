/**
 * 
 */
package com.nagihome.cxf.services;

/**
 * @author nageswararao
 *
 */
public class OrderProcessImpl implements OrderProcess {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.cxf.services.OrderProcess#processOrder(com.nagihome.cxf.
	 * services.Order)
	 */
	@Override
	public String processOrder(Order order) {
		String orderID = validate(order);
		return orderID;
	}

	/*
	 * Validates the order and returns the order ID
	 */
	private String validate(Order order) {

		String custID = order.getCustomerId();
		String itemID = order.getItemId();
		int qty = order.getQty();
		double price = order.getPrice();
		if (custID != null && itemID != null && !custID.equals("") && !itemID.equals("") && qty > 0 && price > 0.0) {
			return "ORD1234";
		}

		return null;
	}

}
