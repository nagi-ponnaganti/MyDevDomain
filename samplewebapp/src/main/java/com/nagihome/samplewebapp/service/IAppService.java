package com.nagihome.samplewebapp.service;

import com.nagihome.samplewebapp.entity.Actor;
import com.nagihome.samplewebapp.entity.Address;
import com.nagihome.samplewebapp.entity.Category;

import java.util.List;

public interface IAppService {

    List<Actor> getAllActors();

    List<Address> getAllAddresses();

    List<Category> getAllCategories();

}
