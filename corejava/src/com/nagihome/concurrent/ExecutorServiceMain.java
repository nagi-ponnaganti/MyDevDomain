/**
 * 
 */
package com.nagihome.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author nageswararao
 *
 */
public class ExecutorServiceMain {

	static ExecutorService execService = Executors.newFixedThreadPool(5);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		playWithAwaitTermination();
		playWithInvokeAll();
	}

	private static void playWithInvokeAll() throws Exception {

		execService = Executors.newFixedThreadPool(1);

		Counter counter = new Counter();

		execService.invokeAll(Collections.nCopies(100, counter).stream().collect(Collectors.toList()), 1000,
				TimeUnit.MILLISECONDS).forEach(x -> {
					try {
						System.out.println("Counter Value: " + x.get());
					} catch (Exception e) {
						e.printStackTrace();
					}
				});

		execService.shutdown();

	}

	private static void playWithAwaitTermination() throws Exception {

		execService.execute(new PrintTask());
		execService.execute(new PrintTask());
		execService.execute(new PrintTask());
		execService.execute(new PrintTask());
		execService.execute(new PrintTask());

		execService.shutdown();

		if (!execService.awaitTermination(1, TimeUnit.SECONDS)) {
			System.out.println("termination not complete : " + execService.isTerminated());
			System.out.println("Force shutdown Now ");

			List<Runnable> pendingTasks = execService.shutdownNow();
			pendingTasks.stream().map(r -> new Thread(r).getName()).forEach(System.out::println);
		}
	}

	static class PrintTask implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Error while sleeping: " + Thread.currentThread().getName());
			}

			System.out.println("Thread Name: " + Thread.currentThread().getName());

		}
	}

	static class Counter implements Callable<Integer> {

		private AtomicInteger counter = new AtomicInteger(0);

		@Override
		public Integer call() throws Exception {
			counter.getAndIncrement();
			return counter.intValue();
		}

	}

}
