/**
 * 
 */
package com.nagihome.jsfdemo.spring;

import org.springframework.stereotype.Component;

/**
 * @author nageswararao
 *
 */
@Component(value = "messageService")
public class MessageServiceImpl implements MessageService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.jsfdemo.spring.MessageService#welcomeMessaage()
	 */
	@Override
	public String welcomeMessage() {
		return "Welcome to JSF and Spring Integration !!!! :) ";
	}

}
