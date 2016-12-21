/**
 * 
 */
package com.nagihome.sakila.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagihome.sakila.dao.ActorDao;
import com.nagihome.sakila.entites.Actor;

/**
 * @author nageswararao
 *
 */
@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorDao actorDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.sakila.service.ActorService#addActor(com.nagihome.sakila.
	 * entites.Actor)
	 */
	@Override
	@Transactional
	public void addActor(Actor actor) {
		actorDao.addActor(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.sakila.service.ActorService#getAllActors()
	 */
	@Override
	@Transactional
	public List<Actor> getAllActors() {
		return actorDao.getAllActors();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.sakila.service.ActorService#deleteActor(int)
	 */
	@Override
	@Transactional
	public void deleteActor(int actorId) {
		actorDao.deleteActor(actorId);
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
