/**
 * 
 */
package com.nagihome.jsfdemo.events;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

/**
 * @author nageswararao
 *
 */
@ManagedBean(name = "countryData", eager = true)
public class CountryData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Map<String, String> countryMap;

	private String coutrySelected = "German";

	static {
		countryMap = new LinkedHashMap<String, String>();
		countryMap.put("en", "United Kingdom"); // locale, country name
		countryMap.put("fr", "French");
		countryMap.put("de", "German");
	}

	public void localeChanged(ValueChangeEvent e) {
		this.coutrySelected = e.getNewValue().toString();
	}

	public Map<String, String> getCountries() {
		return countryMap;
	}

	/**
	 * @return the coutrySelected
	 */
	public String getCoutrySelected() {
		return coutrySelected;
	}

	/**
	 * @param coutrySelected
	 *            the coutrySelected to set
	 */
	public void setCoutrySelected(String coutrySelected) {
		this.coutrySelected = coutrySelected;
	}

}
