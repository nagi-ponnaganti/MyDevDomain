package com.nagihome.samplewebapp.service;

import com.nagihome.samplewebapp.entity.Actor;
import com.nagihome.samplewebapp.entity.Address;
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
}
