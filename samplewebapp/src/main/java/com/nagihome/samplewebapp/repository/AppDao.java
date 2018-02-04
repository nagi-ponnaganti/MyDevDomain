package com.nagihome.samplewebapp.repository;

import com.nagihome.samplewebapp.entity.*;
import com.nagihome.samplewebapp.repository.IAppDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AppDao implements IAppDao {

    private static final String GET_ALL_ACTORS_HSQL = "FROM Actor";
    private static final String GET_ALL_ADDRESSES_HSQL = "FROM Address";
    private static final String GET_ALL_CATEGORY_HSQL = "FROM Category";
    private static final String GET_ALL_CITY_HSQL = "FROM City";
    private static final String GET_ALL_COUNTRIES_HSQL = "FROM Country";
    private static final String GET_ALL_CUSTOMERS_HSQL = "FROM Customer";
    private static final String GET_ALL_FILM_HSQL = "FROM Film";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Actor> getAllActors() {
        return entityManager.createQuery(GET_ALL_ACTORS_HSQL).getResultList();
    }

    @Override
    public List<Address> getAllAddresses() {
        return entityManager.createQuery(GET_ALL_ADDRESSES_HSQL).getResultList();
    }

    @Override
    public List<Category> getAllCategories() {
        return entityManager.createQuery(GET_ALL_CATEGORY_HSQL).getResultList();
    }

    @Override
    public List<City> getAllCities() {
        return entityManager.createQuery(GET_ALL_CITY_HSQL).getResultList();
    }

    @Override
    public List<City> getAllCountries() {
        return entityManager.createQuery(GET_ALL_COUNTRIES_HSQL).getResultList();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery(GET_ALL_CUSTOMERS_HSQL).getResultList();
    }

    @Override
    public List<Film> getAllFilms() {
        return entityManager.createQuery(GET_ALL_FILM_HSQL).getResultList();
    }
}


