/**
 * 
 */
package com.nagihome.jaxb.marshall;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author nageswararao
 *
 */
@XmlType(propOrder = { "name", "capital", "population" })
@XmlRootElement(name = "COUNTRY")
public class Country {

	private String name;
	private int population;
	private String capital;
	private int importance;

	/**
	 * @return the importance
	 */
	public int getImportance() {
		return importance;
	}

	@XmlAttribute(name = "importance")
	public void setImportance(int importance) {
		this.importance = importance;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@XmlElement(name = "COUNTRY_NAME")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param population
	 *            the population to set
	 */
	@XmlElement(name = "COUNTRY_POPULATION")
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * @param capital
	 *            the capital to set
	 */
	@XmlElement(name = "COUNTRY_CAPITAL")
	public void setCapital(String capital) {
		this.capital = capital;
	}

}
