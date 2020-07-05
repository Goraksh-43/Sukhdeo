package com.alighthub.dms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alighthub.dms.model.Nurse;
/*
 * 
 * @author Ravindra Sonawane
 * @page Nurse Dao
 * @time 08/09/2019 - 9.20 PM
 * @purpose To controll Nurse dao
 * 
 *
 */

@Repository
public interface NurseDao extends JpaRepository<Nurse,Integer>{

}
