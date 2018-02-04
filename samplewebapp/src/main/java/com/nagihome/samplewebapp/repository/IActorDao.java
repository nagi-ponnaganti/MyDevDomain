package com.nagihome.samplewebapp.repository;

import com.nagihome.samplewebapp.entity.Actor;

import java.util.List;

public interface IActorDao {

    List<Actor> getAllActors();

}
