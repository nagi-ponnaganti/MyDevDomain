/**
 * 
 */
package com.nagihome.sakila.dao;

import java.util.List;

import com.nagihome.sakila.entites.Actor;

/**
 * @author nageswararao
 *
 */
public interface ActorDao {

	public void addActor(Actor actor);

	public List<Actor> getAllActors();

	public void deleteActor(int actorId);
	

}
