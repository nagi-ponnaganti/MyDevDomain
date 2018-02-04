package com.nagihome.samplewebapp.repository;

import com.nagihome.samplewebapp.entity.Actor;
import com.nagihome.samplewebapp.entity.Address;
import com.nagihome.samplewebapp.entity.Category;

import java.util.List;

public interface IAppDao {

    List<Actor> getAllActors();

    List<Address> getAllAddresses();

    List<Category> getAllCategories();
}
