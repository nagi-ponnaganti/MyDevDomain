/**
 * 
 */
package com.nagihome.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author nageswararao
 *
 */
public class ArrayBlockingQueueDemo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

		int noOfThreads = 10;
		for (int i = 0; i < noOfThreads; i++) {
			System.out.println("Adding message:" + queue.offer("Nagi " + i, 1000, TimeUnit.MILLISECONDS));
		}

		/*
		 * int noOfThreads = 4; for (int i = 0; i < noOfThreads; i++) { Thread
		 * thread = new Thread(new Putter("Nagi " + i, queue));
		 * thread.setName("Putter Thread " + i); Thread.sleep(1000);
		 * thread.start(); }
		 * 
		 * for (int i = 0; i < noOfThreads; i++) { Thread thread = new
		 * Thread(new Getter(queue)); thread.setName("Getter Thread " + i);
		 * Thread.sleep(1000); thread.start(); }
		 */
		System.out.println("queue size: " + queue.size());

	}

	static class Getter implements Runnable {

		private ArrayBlockingQueue<String> queue;

		public Getter(ArrayBlockingQueue<String> queue) throws Exception {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				System.out.println("Getting Message For Thread: "
						+ Thread.currentThread().getName()
						+ " and the value is: " + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * @return the queue
		 */
		public ArrayBlockingQueue<String> getQueue() {
			return queue;
		}

		/**
		 * @param queue
		 *            the queue to set
		 */
		public void setQueue(ArrayBlockingQueue<String> queue) {
			this.queue = queue;
		}

	}

	static class Putter implements Runnable {

		private String input;
		private ArrayBlockingQueue<String> queue;

		public Putter(String putterString, ArrayBlockingQueue<String> queue) {
			this.setInput(putterString);
			this.setQueue(queue);
		}

		@Override
		public void run() {
			System.out.println("Putting message for thread: "
					+ Thread.currentThread().getName()
					+ " and the input value is : " + input);
			try {
				queue.put(input);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * @return the input
		 */
		public String getInput() {
			return input;
		}

		/**
		 * @param input
		 *            the input to set
		 */
		public void setInput(String input) {
			this.input = input;
		}

		/**
		 * @return the queue
		 */
		public ArrayBlockingQueue<String> getQueue() {
			return queue;
		}

		/**
		 * @param queue
		 *            the queue to set
		 */
		public void setQueue(ArrayBlockingQueue<String> queue) {
			this.queue = queue;
		}
	}
}
