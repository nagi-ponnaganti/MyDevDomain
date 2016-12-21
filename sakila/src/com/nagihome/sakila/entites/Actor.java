/**
 * 
 */
package com.nagihome.sakila.entites;

import java.util.Date;

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
@Table(name = "actor")
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	private int actorId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "last_update")
	private Date lastUpdateTS;

	/**
	 * @return the actorId
	 */
	public int getActorId() {
		return actorId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the lastUpdateTS
	 */
	public Date getLastUpdateTS() {
		return lastUpdateTS;
	}

	/**
	 * @param actorId
	 *            the actorId to set
	 */
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param lastUpdateTS
	 *            the lastUpdateTS to set
	 */
	public void setLastUpdateTS(Date lastUpdateTS) {
		this.lastUpdateTS = lastUpdateTS;
	}

}
