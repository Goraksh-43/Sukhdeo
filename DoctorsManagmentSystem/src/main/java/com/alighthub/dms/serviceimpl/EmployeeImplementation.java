package com.alighthub.dms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alighthub.dms.dao.DoctorDao;
import com.alighthub.dms.dao.EmployeeDao;
import com.alighthub.dms.dao.LoginDao;
import com.alighthub.dms.model.Doctor;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.service.EmployeeService;

@Service
public class EmployeeImplementation implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeedao;
	
	@Autowired
	private DoctorDao doctordao;
	
	@Autowired 
	private LoginDao log;
	
	@Override
	public void addEmployee(Employee e) {
	
		employeedao.save(e);
		
	}

	@Override
	public Employee getEmployee(String uname, String pass) {
		// TODO Auto-generated method stub
		Employee e=employeedao.findByUnameAndPass(uname, pass);
		return e;
	}

	@Override
	public Employee editEmployee(int id) {
		 
		Employee e=employeedao.findById(id).get();
		return e;
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		employeedao.save(e);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeedao.deleteById(id);
		
	}

	@Override
	public List<Employee> search(String name) {
	
		return null;
	}

	@Override
	public Login getData(String uname, String pass) {
		// TODO Auto-generated method stub
		return log.findByLoginunameAndLoginpassword(uname, pass);
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return employeedao.count();
	}

	@Override
	public List<Doctor> getDoctorUnderEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;//employeedao.findByDoctorUnderEmployee(empId);
	}

	@Override
	public Employee findByLoginuname(String uname) {
		// TODO Auto-generated method stub
		return employeedao.findeByLoginuname(uname);
	}

	/*
	 * @Override public List<Doctor> viewDoctorsUnderEmployee(int employeeId) { //
	 * TODO Auto-generated method stub return
	 * doctordao.findDoctorUnderEmployee(employeeId); }
	 */

	/*
	 * @Override public long getDoctorCount() { // TODO Auto-generated method stub
	 * return doctordao.count(); }
	 */



}
