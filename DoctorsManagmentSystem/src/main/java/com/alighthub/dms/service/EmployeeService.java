package com.alighthub.dms.service;

import java.util.List;

import com.alighthub.dms.model.Doctor;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.model.Login;

public interface EmployeeService {
	
	public void addEmployee(Employee e);
	Employee getEmployee(String uname, String pass);
	Employee editEmployee(int id);
	void updateEmployee(Employee e);
	void delete(int id);
	public List<Employee> search(String name);
	public Login getData(String uname,String pass);
	public long getCount();
	//public List<Doctor> viewDoctorsUnderEmployee(int employeeId);
	//public long getDoctorCount();
	public List<Doctor> getDoctorUnderEmployee(int empId);
	public Employee findByLoginuname(String uname);

}
