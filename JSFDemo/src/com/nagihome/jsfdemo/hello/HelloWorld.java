/**
 * 
 */
package com.nagihome.jsfdemo.hello;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author nageswararao
 *
 */
@ManagedBean(name = "helloWorld", eager = true)
@ApplicationScoped
public class HelloWorld {
	
	private int counter;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		counter = counter + 1;
		return "Hello World! " + counter;
	}

}
