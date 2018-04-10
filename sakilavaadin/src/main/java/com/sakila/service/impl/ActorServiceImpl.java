package com.sakila.service.impl;

import com.sakila.dao.ActorDao;
import com.sakila.domain.Actor;
import com.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorDao actorDao;

    @Override
    public List<Actor> getAllActors() {
        return actorDao.getAllActors();
    }
}
