package com.nagihome.lang;

public class MathMain {

	public static void main(String[] args) {
		
		log("Math.E", Math.E);
		log("Math.PI", Math.PI);
		log("Math.abs(-3.24)", Math.abs(-3.24));
		log("Math.abs(-3)", Math.abs(-3));
		log("Math.addExact(1234, 1234)",Math.addExact(1234, 1234));
	}
	
	static void log(String log, Object obj) {
		System.out.println(log + " : " + obj);
	}

}
