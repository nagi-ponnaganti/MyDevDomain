package com.sakila.dao.impl;

import com.sakila.dao.ActorDao;
import com.sakila.domain.Actor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ActorDaoImpl implements ActorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Actor> getAllActors() {
        return entityManager.createQuery("from Actor").getResultList();
    }

}
