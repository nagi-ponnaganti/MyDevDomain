package com.nagihome.concurrent.threadlocal;

public class ThreadLocalMain {

	public static void main(String[] args) {
		
		MyRunnable myRun = new MyRunnable();
		
		new Thread(myRun).start();
		new Thread(myRun).start();
	}

	static class MyRunnable implements Runnable {

		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

		@Override
		public void run() {

			threadLocal.set((int) (Math.random() * 100D));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("threadLocal value: " + threadLocal.get());

		}

	}

}
