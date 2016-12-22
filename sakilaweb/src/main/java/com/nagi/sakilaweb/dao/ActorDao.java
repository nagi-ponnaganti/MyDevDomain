/**
 * 
 */
package com.nagi.sakilaweb.dao;

import java.util.List;

import com.nagi.sakilaweb.vo.Actor;

/**
 * @author nageswararao
 *
 */
public interface ActorDao {

	void save(Actor actor);

	void update(Actor actor);

	void delete(Actor actor);

	Actor findByActorId(String actorId);

	List<Actor> getAllActors();

}
