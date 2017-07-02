/**
 * 
 */
package com.nagihome.concurrent.canteen;

/**
 * @author nageswararao
 *
 */
public class FoodPlate {
	
	private boolean isPizzaReady;
	private boolean isBurgerReady;
	private boolean isOtherJunkReady;
	private String foodPlateCreatedBy;
	
	public boolean isPizzaReady() {
		return isPizzaReady;
	}
	public boolean isBurgerReady() {
		return isBurgerReady;
	}
	public boolean isOtherJunkReady() {
		return isOtherJunkReady;
	}
	public String getFoodPlateCreatedBy() {
		return foodPlateCreatedBy;
	}
	public void setPizzaReady(boolean isPizzaReady) {
		this.isPizzaReady = isPizzaReady;
	}
	public void setBurgerReady(boolean isBurgerReady) {
		this.isBurgerReady = isBurgerReady;
	}
	public void setOtherJunkReady(boolean isOtherJunkReady) {
		this.isOtherJunkReady = isOtherJunkReady;
	}
	public void setFoodPlateCreatedBy(String foodPlateCreatedBy) {
		this.foodPlateCreatedBy = foodPlateCreatedBy;
	}
	@Override
	public String toString() {
		return "FoodPlate [isPizzaReady=" + isPizzaReady + ", isBurgerReady=" + isBurgerReady + ", isOtherJunkReady="
				+ isOtherJunkReady + ", foodPlateCreatedBy=" + foodPlateCreatedBy + "]";
	}

}
