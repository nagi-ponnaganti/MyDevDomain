package com.nagihome.samplewebapp.repository;

import com.nagihome.samplewebapp.entity.Actor;
import com.nagihome.samplewebapp.entity.Address;
import com.nagihome.samplewebapp.repository.IAppDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AppDao implements IAppDao {

    @PersistenceContext
    private EntityManager entityManager;
    private static final String GET_ALL_ACTORS_HSQL = "FROM Actor";

    @Override
    public List<Actor> getAllActors() {
        return entityManager.createQuery(GET_ALL_ACTORS_HSQL).getResultList();
    }

    private static final String GET_ALL_ADDRESSES_HSQL = "FROM Address";


    @Override
    public List<Address> getAllAddresses() {
        return entityManager.createQuery(GET_ALL_ADDRESSES_HSQL).getResultList();
    }
}


