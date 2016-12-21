/**
 * 
 */
package com.nagihome.jsfdemo.jdbcintegration;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @author nageswararao
 *
 */
public class ActorDaoImpl extends HibernateDaoSupport implements ActorDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorDao#save(com.nagihome.jsfdemo.
	 * jdbcintegration.Actor)
	 */
	@Override
	public void save(Actor actor) {
		getHibernateTemplate().save(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorDao#update(com.nagihome.jsfdemo
	 * .jdbcintegration.Actor)
	 */
	@Override
	public void update(Actor actor) {
		getHibernateTemplate().update(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorDao#delete(com.nagihome.jsfdemo
	 * .jdbcintegration.Actor)
	 */
	@Override
	public void delete(Actor actor) {
		getHibernateTemplate().delete(actor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagihome.jsfdemo.jdbcintegration.ActorDao#findByActorId(java.lang.
	 * String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Actor findByActorId(String actorId) {
		List<Actor> list = (List<Actor>) getHibernateTemplate().find("from Actor where actorId=?", actorId);
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actor> getAllActors() {
		return (List<Actor>) getHibernateTemplate().find("from Actor");
	}

}
