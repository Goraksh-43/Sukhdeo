package com.cjc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.model.City;
@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
