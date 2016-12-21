/**
 * 
 */
package com.nagihome.sakila.service;

import java.util.List;

import com.nagihome.sakila.entites.Actor;

/**
 * @author nageswararao
 *
 */
public interface ActorService {

	public void addActor(Actor actor);

	public List<Actor> getAllActors();

	public void deleteActor(int actorId);

}
