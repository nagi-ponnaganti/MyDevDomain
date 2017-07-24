/**
 * 
 */
package com.nagihome.concurrent;

/**
 * @author nageswararao
 *
 */
public class ProducerConsumerProblem {

	class CubbyHole {
		
		private int contents;
		private boolean avalible;

		public synchronized int get() {

			if (avalible == false) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Exception while waiting");
				}
			}

			avalible = false;
			notifyAll();
			return contents;
		}

		public synchronized void put(int input) {

			if (avalible == true) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Exception while waiting");
				}
			}

			avalible = true;
			contents = input;
			notifyAll();

		}

	}

}
