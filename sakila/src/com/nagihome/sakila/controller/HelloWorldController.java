/**
 * 
 */
package com.nagihome.sakila.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nageswararao
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	private static final Logger LOGGER = Logger.getLogger(HelloWorldController.class.getName());

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView sayHelloWorld() {
		LOGGER.info("This is Hitting Hello World");

		ModelAndView model = new ModelAndView("hello");

		model.addObject("Message", "Hello World!");

		return model;
	}

}
