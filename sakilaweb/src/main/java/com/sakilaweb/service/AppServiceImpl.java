package com.sakilaweb.service;

import com.sakilaweb.domain.Actor;
import com.sakilaweb.repository.AppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepo appRepo;

    @Override
    public List<Actor> getAllActors() {
        return appRepo.getAllActors();
    }

}
