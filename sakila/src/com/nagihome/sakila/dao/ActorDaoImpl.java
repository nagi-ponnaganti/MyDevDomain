/**
 * 
 */
package com.nagihome.sakila.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagihome.sakila.entites.Actor;

/**
 * @author nageswararao
 *
 */
@Repository
public class ActorDaoImpl implements ActorDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.sakila.dao.ActorDao#addActor(com.nagihome.sakila.entites.
	 * Actor)
	 */
	@Override
	public void addActor(Actor actor) {
		sessionFactory.getCurrentSession().save(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.sakila.dao.ActorDao#getAllActors()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> getAllActors() {
		return sessionFactory.getCurrentSession().createQuery("from Actor").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nagihome.sakila.dao.ActorDao#getActor(int)
	 */
	@Override
	public void deleteActor(int actorId) {
		Actor actor = sessionFactory.getCurrentSession().load(Actor.class, actorId);

		if (actor != null) {
			sessionFactory.getCurrentSession().delete(actor);
		}

	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
