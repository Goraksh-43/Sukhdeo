package com.cjc.dao;

import org.springframework.data.repository.CrudRepository;

import com.cjc.model.Customer;
 
 
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
