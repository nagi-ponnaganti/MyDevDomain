/**
 * 
 */
package com.nagihome.types;

import java.net.URL;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nageswararao
 *
 */
@Entity
@Table(name = "CONTACT")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Basic(optional=false)
	private String name;
	
	@Column(name="NOTES")
	private String notes;
	private URL website;
	private boolean starred;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the website
	 */
	public URL getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(URL website) {
		this.website = website;
	}

	/**
	 * @return the starred
	 */
	public boolean isStarred() {
		return starred;
	}

	/**
	 * @param starred
	 *            the starred to set
	 */
	public void setStarred(boolean starred) {
		this.starred = starred;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
