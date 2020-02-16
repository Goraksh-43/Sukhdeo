package com.cjc.serv;

import java.util.List;

import javax.mail.MessagingException;

import com.cjc.model.City;

public interface ICityService {

	List<City> findAll();
	
}
