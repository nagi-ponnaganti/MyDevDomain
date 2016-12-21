/**
 * 
 */
package com.nagihome.jaxb.marshall;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nageswararao
 *
 */
@XmlRootElement(name = "COUNTRIES")
public class Countries {

	private List<Country> countries;

	/**
	 * @return the countries
	 */
	@XmlElementWrapper(name = "wrapper")
	public List<Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	@XmlElement(name = "COUNTRY")
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
