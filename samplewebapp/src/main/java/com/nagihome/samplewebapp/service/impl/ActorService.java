package com.nagihome.samplewebapp.service.impl;

import com.nagihome.samplewebapp.entity.Actor;
import com.nagihome.samplewebapp.repository.IActorDao;
import com.nagihome.samplewebapp.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired
    private IActorDao actorDao;

    @Override
    public List<Actor> getAllActors() {
        return actorDao.getAllActors();
    }

}
