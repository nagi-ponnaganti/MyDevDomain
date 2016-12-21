package com.nagihome.testwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestingWebAppController {

	@RequestMapping("/welcometest")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from TestingWebAppController.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

}
