/**
 * 
 */
package com.nagihome.jsfdemo.spring;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * @author nageswararao
 *
 */
@ManagedBean(name = "uiBean", eager = true)
@SessionScoped
public class UIBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{messageService}")
	private MessageService messageService;

	public String showWelcomeMessage() {
		return messageService.welcomeMessage();
	}

	/**
	 * @return the messageService
	 */
	public MessageService getMessageService() {
		return messageService;
	}

	/**
	 * @param messageService
	 *            the messageService to set
	 */
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
