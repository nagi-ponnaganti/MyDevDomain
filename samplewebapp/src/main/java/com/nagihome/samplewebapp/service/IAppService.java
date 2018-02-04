package com.nagihome.samplewebapp.service;

import com.nagihome.samplewebapp.entity.*;

import java.util.List;

public interface IAppService {

    List<Actor> getAllActors();

    List<Address> getAllAddresses();

    List<Category> getAllCategories();

    List<City> getAllCities();

    List<City> getAllCountries();

    List<Customer> getAllCustomers();

    List<Film> getAllFilms();
}
