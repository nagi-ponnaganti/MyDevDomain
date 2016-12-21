/**
 * 
 */
package com.nagihome.jsfdemo.basictags;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author nageswararao
 *
 */
@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	public String[] data = { "1", "2", "3" };
	public String dataOne = "1";

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	/**
	 * @return the dataOne
	 */
	public String getDataOne() {
		return dataOne;
	}

	/**
	 * @param dataOne
	 *            the dataOne to set
	 */
	public void setDataOne(String dataOne) {
		this.dataOne = dataOne;
	}

	public String showResult() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> keyValues = fc.getExternalContext().getRequestParameterMap();
		dataOne = keyValues.get("username");
		return "result";
	}

	public String welcomeMessage() {
		return "Hello " + dataOne;
	}

}
