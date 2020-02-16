package com.cjc.servImp;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.dao.CityRepository;
import com.cjc.model.City;
import com.cjc.serv.ICityService;
@Service
public class CityService implements ICityService {
	
	@Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        return  repository.findAll();

    }

}
