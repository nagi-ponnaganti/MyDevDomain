/**
 * 
 */
package com.pwj.model;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 * @author Nagi
 *
 */
@ManagedBean
@SessionScoped
public class UserBean {

	private String firstName;
	private String lastName;
	private Date dob;
	private String sex;
	private String email;
	private String serviceLevel = "medium";

	public void validateEmail(FacesContext facesContext, UIComponent uiComponent, Object value)
			throws ValidatorException {
		String emailStr = (String) value;

		if (-1 == emailStr.indexOf("@")) {
			FacesMessage facesMessage = new FacesMessage("Invalid Email Address");
			throw new ValidatorException(facesMessage);
		}
	}
	
	public String addConfirmedUser() {
		
		boolean added = true;
		FacesMessage doneMessage = null;
		String outcome = null;
		
		if(added) {
			doneMessage = new FacesMessage("Successfully added the new user");
			outcome = "done";
		} else {
			doneMessage = new FacesMessage("Failed to add new user");
			outcome = "register";
		}
		
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
				
		return outcome;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

}
