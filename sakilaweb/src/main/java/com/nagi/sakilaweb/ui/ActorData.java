/**
 * 
 */
package com.nagi.sakilaweb.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.nagi.sakilaweb.service.ActorService;
import com.nagi.sakilaweb.vo.Actor;

/**
 * @Actor nageswararao
 *
 */
@ManagedBean(name = "actorData", eager = true)
@SessionScoped
public class ActorData implements Serializable {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{actorService}")
	private ActorService actorService;

	public List<Actor> getAllActors() throws Exception {
		return actorService.getAllActors();
	}

	/**
	 * @return the actorService
	 */
	public ActorService getActorService() {
		return actorService;
	}

	/**
	 * @param actorService
	 *            the actorService to set
	 */
	public void setActorService(ActorService actorService) {
		this.actorService = actorService;
	}

	/*
	 * public List<Actor> getActors() throws Exception { ResultSet rs = null;
	 * PreparedStatement pst = null; Connection con = getConnection(); String
	 * stm = "Select * from actor"; List<Actor> records = new
	 * ArrayList<Actor>(); try { pst = con.prepareStatement(stm); pst.execute();
	 * rs = pst.getResultSet();
	 * 
	 * while (rs.next()) { Actor Actor = new Actor();
	 * Actor.setActorId(rs.getInt(1)); Actor.setFirstName(rs.getString(2));
	 * Actor.setLastName(rs.getString(3));
	 * Actor.setLastUpdateTimeStamp(rs.getDate(4)); records.add(Actor); } }
	 * catch (SQLException e) { e.printStackTrace(); } return records; }
	 * 
	 * public Connection getConnection() throws Exception { Connection con =
	 * null;
	 * 
	 * String url = "jdbc:mysql://localhost:3306/sakila"; String user =
	 * "sakilaproid"; String password = "sakilaproid"; try {
	 * Class.forName("com.mysql.jdbc.Driver"); con =
	 * DriverManager.getConnection(url, user, password);
	 * System.out.println("Connection completed."); } catch (SQLException ex) {
	 * System.out.println(ex.getMessage()); } finally { } return con; }
	 */

}
