/**
 * 
 */
package com.nagihome.jsfdemo.jdbcintegration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nageswararao
 *
 */
@Service(value = "actorService")
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorDao actorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.jsfdemo.jdbcintegration.ActorService#save(com.nagihome.
	 * jsfdemo.jdbcintegration.Actor)
	 */
	@Override
	public void save(Actor actor) {
		actorDao.save(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorService#update(com.nagihome.
	 * jsfdemo.jdbcintegration.Actor)
	 */
	@Override
	public void update(Actor actor) {
		actorDao.update(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorService#delete(com.nagihome.
	 * jsfdemo.jdbcintegration.Actor)
	 */
	@Override
	public void delete(Actor actor) {
		actorDao.delete(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorService#findByActorId(java.lang
	 * .String)
	 */
	@Override
	public Actor findByActorId(String actorId) {
		return actorDao.findByActorId(actorId);
	}

	@Override
	public List<Actor> getAllActors() {
		return actorDao.getAllActors();
	}

	/**
	 * @return the actorDao
	 */
	public ActorDao getActorDao() {
		return actorDao;
	}

	/**
	 * @param actorDao
	 *            the actorDao to set
	 */
	public void setActorDao(ActorDao actorDao) {
		this.actorDao = actorDao;
	}

}
