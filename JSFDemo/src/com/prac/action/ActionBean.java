package com.prac.action;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
@SuppressWarnings("serial")
public class ActionBean implements Serializable {
	
	public String action() {
		return "action-2?faces-redirect=true";
	}
	
	public void actionListener(ActionEvent ae) {
		System.out.println("Action Event Details: " + ae.getSource());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This is actionListener"));
	}
	

}
