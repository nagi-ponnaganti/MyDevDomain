/**
 * 
 */
package com.nagihome.java8.streams;

import java.util.Arrays;
import java.util.List;

/**
 * @author nageswararao
 *
 */
public class TradeDataProvider {

	static Trader raoul = new Trader("Raoul", "Cambridge");
	static Trader mario = new Trader("Mario", "Milan");
	static Trader alan = new Trader("Alan", "Cambridge");
	static Trader brian = new Trader("Brian", "Cambridge");

	static List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
	static List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300, "USD"),
			new Transaction(raoul, 2012, 1000, "GBP"), new Transaction(raoul, 2011, 400, "USD"),
			new Transaction(mario, 2012, 710, "EUR"), new Transaction(mario, 2012, 700, "GBP"),
			new Transaction(alan, 2012, 950, "USD"));

	public static List<Trader> getTraderData() {
		return traders;
	}

	public static List<Transaction> getTransactionData() {
		return transactions;
	}

}
