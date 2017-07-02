/**
 * 
 */
package com.nagihome.java8.streams;

/**
 * @author nageswararao
 *
 */
public class Transaction {
	private final Trader trader;
	private final int year;
	private final int value;
	private final String currency;

	public Transaction(Trader trader, int year, int value, String currency) {
		this.trader = trader;
		this.year = year;
		this.value = value;
		this.currency = currency;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + ", currency=" + currency + "]";
	}
}
