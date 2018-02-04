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
    private static final String GET_ALL_FILM_ACTOR_HSQL = "FROM FilmActor";
    private static final String GET_ALL_FILM_CATEGORY_HSQL = "FROM FilmCategory";
    private static final String GET_ALL_FILM_TEXT_HSQL = "FROM FilmText";
    private static final String GET_ALL_INVENTORY_HSQL = "FROM Inventory";
    private static final String GET_ALL_LANGUAGE_HSQL = "FROM Language";
    private static final String GET_ALL_PAYMENT_HSQL = "FROM Payment";
    private static final String GET_ALL_RENTAL_HSQL = "FROM Rental";
    private static final String GET_ALL_STAFF_HSQL = "FROM Staff";
    private static final String GET_ALL_STORE_HSQL = "FROM Store";


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

    @Override
    public List<FilmActor> getAllFilmActors() {
        return entityManager.createQuery(GET_ALL_FILM_ACTOR_HSQL).getResultList();
    }

    @Override
    public List<FilmCategory> getAllFilmCategories() {
        return entityManager.createQuery(GET_ALL_FILM_CATEGORY_HSQL).getResultList();
    }

    @Override
    public List<FilmText> getAllFilmTexts() {
        return entityManager.createQuery(GET_ALL_FILM_TEXT_HSQL).getResultList();
    }

    @Override
    public List<Inventory> getAllInventories() {
        return entityManager.createQuery(GET_ALL_INVENTORY_HSQL).getResultList();
    }

    @Override
    public List<Language> getAllLanguages() {
        return entityManager.createQuery(GET_ALL_LANGUAGE_HSQL).getResultList();
    }

    @Override
    public List<Payment> getAllPayments() {
        return entityManager.createQuery(GET_ALL_PAYMENT_HSQL).getResultList();
    }

    @Override
    public List<Rental> getAllRentals() {
        return entityManager.createQuery(GET_ALL_RENTAL_HSQL).getResultList();
    }

    @Override
    public List<Rental> getAllStaffs() {
        return entityManager.createQuery(GET_ALL_STAFF_HSQL).getResultList();
    }

    @Override
    public List<Store> getAllStore() {
        return entityManager.createQuery(GET_ALL_STORE_HSQL).getResultList();
    }

}


