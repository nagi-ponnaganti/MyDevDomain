/**
 * 
 */
package com.nagihome.concurrent;

import java.util.concurrent.Executor;

/**
 * @author nageswararao
 *
 */
class ExecutorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DirectExecutor directExecutor = new DirectExecutor();
		System.out.println("Direct Executor");
		directExecutor.execute(new PrintTask());

	}

	static class DirectExecutor implements Executor {

		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}

	static class PrintTask implements Runnable {

		@Override
		public void run() {			
			System.out.println("PrintTask: " + Thread.currentThread().getName());
		}

	}

}
