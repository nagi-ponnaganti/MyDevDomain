package com.nagihome.javafx.chapter02;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {

	private StringProperty title = new SimpleStringProperty(this, "title", "Unknown");
	private DoubleProperty price = new SimpleDoubleProperty(this, "price", 0d);
	private ReadOnlyStringWrapper ISBN = new ReadOnlyStringWrapper(this, "ISBN", "Unknown");

	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getTitle() {
		return this.title.get();
	}

	public double getPrice() {
		return this.price.get();
	}

	public void setPrice(double price) {
		this.price.set(price);
	}

	public String getISBN() {
		return this.ISBN.get();
	}

	public StringProperty titleProperty() {
		return this.title;
	}

	public DoubleProperty priceProperty() {
		return this.price;
	}

	public ReadOnlyStringProperty ISBNProperty() {
		return this.ISBN.getReadOnlyProperty();
	}

}
