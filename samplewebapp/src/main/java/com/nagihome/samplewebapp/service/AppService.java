package com.nagihome.samplewebapp.service;

import com.nagihome.samplewebapp.entity.*;
import com.nagihome.samplewebapp.repository.IAppDao;
import com.nagihome.samplewebapp.service.IAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService implements IAppService {

    @Autowired
    private IAppDao appDao;

    @Override
    public List<Actor> getAllActors() {
        return appDao.getAllActors();
    }

    @Override
    public List<Address> getAllAddresses() {
        return appDao.getAllAddresses();
    }

    @Override
    public List<Category> getAllCategories() {
        return appDao.getAllCategories();
    }

    @Override
    public List<City> getAllCities() {
        return appDao.getAllCities();
    }

    @Override
    public List<City> getAllCountries() {
        return appDao.getAllCountries();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return appDao.getAllCustomers();
    }

    @Override
    public List<Film> getAllFilms() {
        return appDao.getAllFilms();
    }

    @Override
    public List<FilmActor> getAllFilmActors() {
        return appDao.getAllFilmActors();
    }

    @Override
    public List<FilmCategory> getAllFilmCategories() {
        return appDao.getAllFilmCategories();
    }

    @Override
    public List<FilmText> getAllFilmTexts() {
        return appDao.getAllFilmTexts();
    }

    @Override
    public List<Inventory> getAllInventories() {
        return appDao.getAllInventories();
    }

    @Override
    public List<Language> getAllLanguages() {
        return appDao.getAllLanguages();
    }

    @Override
    public List<Payment> getAllPayments() {
        return appDao.getAllPayments();
    }

    @Override
    public List<Rental> getAllRentals() {
        return appDao.getAllRentals();
    }

    @Override
    public List<Rental> getAllStaffs() {
        return appDao.getAllStaffs();
    }

}
