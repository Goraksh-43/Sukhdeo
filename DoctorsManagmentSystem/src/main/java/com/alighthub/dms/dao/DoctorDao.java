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
 * @page Doctor Dao
 * @time 08/09/2019 - 9.20 PM
 * @purpose To controll doctor dao
 * 
 *
 */
@Repository
public interface DoctorDao extends JpaRepository<Doctor,Integer>{
	
	/*
	 * @Query("from Doctor d where d.employee.employeeId=:employeeId") List<Doctor>
	 * findDoctorUnderEmployee(int employeeId);
	 */
	

	@Query("from Doctor d where empId=:empId")
	public List<Doctor> findByDoctorUnderEmployee(int empId);
	
	@Query("from Doctor d left outer join Login l on d.login=l.loginId where l.loginuname=:uname AND l.loginpassword=:pass")
	public Doctor findByUnameAndPass(String uname,String pass);

	

	

}
