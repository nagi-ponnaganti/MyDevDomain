package com.nagihome.samplewebapp.repository.impl;

import com.nagihome.samplewebapp.entity.Actor;
import com.nagihome.samplewebapp.repository.IActorDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ActorDao implements IActorDao {

    @PersistenceContext
    private EntityManager entityManager;
    private static final String GET_ALL_ACTORS_HSQL = "FROM Actor";

    @Override
    public List<Actor> getAllActors() {
        return entityManager.createQuery(GET_ALL_ACTORS_HSQL).getResultList();
    }

}
