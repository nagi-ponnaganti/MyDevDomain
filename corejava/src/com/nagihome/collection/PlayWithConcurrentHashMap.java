/**
 * 
 */
package com.nagihome.collection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * @author nageswararao
 *
 */
public class PlayWithConcurrentHashMap {

	static Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd"));

		
		System.out.println("Date: " + formatter.format(LocalDate.now()));

		loadData();

		Executors.newCachedThreadPool().submit(new Runnable() {

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				System.out.println("Adding Element");
				map.put("Gamma", 105);

				try {
					System.out.println("sleeping in thread");
					Thread.currentThread().sleep(5000);
					System.out.println("woke-up");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

/*		System.out.println("Sleep in Main Thread for 1 Sec");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("woke-up in Main Thread for 1 Sec");*/

		// Iterator<String> it = map.keySet().iterator();

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.format("Key:%s Value:%s \n", new Object[] { entry.getKey(), entry.getValue() });
			try {
				System.out.println("Sleep in Main Thread for 1 Sec");
				Thread.sleep(1000);
				System.out.println("woke-up in Main Thread for 1 Sec");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void loadData() {
		map.put("Nagi", 100);
		map.put("Moni", 101);
		map.put("Gomi", 103);
		map.put("Magi", 104);
	}

}
