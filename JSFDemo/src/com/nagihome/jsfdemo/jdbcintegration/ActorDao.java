/**
 * 
 */
package com.nagihome.jsfdemo.jdbcintegration;

import java.util.List;

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
