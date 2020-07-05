package com.alighthub.dms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alighthub.dms.model.Doctor;
import com.alighthub.dms.model.Employee;

/*
 * 
 * @author Ravindra Sonawane
 * @page Employee Dao
 * @time 08/09/2019 - 9.20 PM
 * @purpose To controll employee dao
 * 
 *
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{
	
	@Query("from Employee e left outer join Login l on e.login=l.loginId where l.loginuname=:uname AND l.loginpassword=:pass")
	public Employee findByUnameAndPass(String uname,String pass);
	

	public List<Employee> findByEmployeeFname(String name);

	@Query("from Employee e right outer join Login l on e.login=l.loginId where l.loginuname=:uname")
	public Employee findeByLoginuname(String uname);


}
