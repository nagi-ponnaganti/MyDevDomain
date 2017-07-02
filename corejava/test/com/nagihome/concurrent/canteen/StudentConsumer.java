/**
 * 
 */
package com.nagihome.concurrent.canteen;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author nageswararao
 *
 */
public class StudentConsumer implements Runnable {

	public StudentConsumer(String stuName, CompletionService<FoodPlate> completionService) {
		this.completionService = completionService;
		this.studentName = stuName;
	}

	private CompletionService<FoodPlate> completionService;
	private String studentName;

	@Override
	public void run() {

		try {
			
			Future<FoodPlate> result = completionService.take();
			FoodPlate fp = result.get();
			System.out.format("Student: %s is taken the food meal: %s \n", studentName, fp.toString());

		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("Exception while processing the result");
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public CompletionService<FoodPlate> getCompletionService() {
		return completionService;
	}

	public void setCompletionService(CompletionService<FoodPlate> completionService) {
		this.completionService = completionService;
	}

}
