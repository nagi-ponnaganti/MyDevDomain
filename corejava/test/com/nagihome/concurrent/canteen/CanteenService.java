/**
 * 
 */
package com.nagihome.concurrent.canteen;

import java.util.concurrent.CompletionService;

/**
 * @author nageswararao
 *
 */
public class CanteenService {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		CompletionService<FoodPlate> compService = CompletionServiceProvider.getInstance();
		
		compService.submit(new CanteenStaffProducer("Nagi"));
		compService.submit(new CanteenStaffProducer("Magi"));
		
		new Thread(new StudentConsumer("Student1", compService)).start();;
		new Thread(new StudentConsumer("Student2", compService)).start();		
		
	}

}
