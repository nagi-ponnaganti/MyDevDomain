/**
 * 
 */
package com.nagihome.javafx.datastore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author nageswararao
 *
 */
@Entity
@Table(name = "actor", catalog = "sakila")
public class Actor implements Serializable {

	private static final long serialVersionUID = -8411160850657993774L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "actor_id", unique = true, nullable = false)
	private int actorId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "last_update", nullable = false)
	private Date lastUpdateTS;

	public int getActorId() {
		return actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdateTS() {
		return lastUpdateTS;
	}

	public void setLastUpdateTS(Date lastUpdateTS) {
		this.lastUpdateTS = lastUpdateTS;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdateTS="
				+ lastUpdateTS + "]";
	}

}
