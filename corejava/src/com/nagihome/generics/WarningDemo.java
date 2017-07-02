package com.nagihome.generics;

public class WarningDemo {
	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {
		Box<Integer> bi;
		bi = createBox();
	}

	@SuppressWarnings("rawtypes")
	static Box createBox() {
		return new Box();
	}
}