package com.sakilaweb.repository;

import com.sakilaweb.domain.Actor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AppRepoImpl implements AppRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Actor> getAllActors() {
        return entityManager.createQuery("from Actor", Actor.class).getResultList();
    }
}
