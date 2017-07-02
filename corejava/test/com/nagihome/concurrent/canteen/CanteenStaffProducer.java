/**
 * 
 */
package com.nagihome.concurrent.canteen;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @author nageswararao
 *
 */
public class CanteenStaffProducer implements Callable<FoodPlate> {

	private String staffName;

	public CanteenStaffProducer(String prodName) {
		this.staffName = prodName;
	}

	@Override
	public FoodPlate call() throws Exception {

		System.out.format("Current Canteen Staff is at work, Name: %s and time: %s \n", staffName, new Date());

		Thread.sleep(2000L);

		FoodPlate foodPlate = new FoodPlate();
		foodPlate.setBurgerReady(true);
		foodPlate.setFoodPlateCreatedBy(staffName);
		foodPlate.setOtherJunkReady(true);
		foodPlate.setPizzaReady(true);

		return foodPlate;
	}

}
