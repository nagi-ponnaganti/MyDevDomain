package com.nagihome.samplewebapp.repository;

import com.nagihome.samplewebapp.entity.*;

import java.util.List;

public interface IAppDao {

    List<Actor> getAllActors();

    List<Address> getAllAddresses();

    List<Category> getAllCategories();

    List<City> getAllCities();

    List<City> getAllCountries();

    List<Customer> getAllCustomers();

    List<Film> getAllFilms();

    List<FilmActor> getAllFilmActors();

    List<FilmCategory> getAllFilmCategories();

    List<FilmText> getAllFilmTexts();

    List<Inventory> getAllInventories();

    List<Language> getAllLanguages();
}
