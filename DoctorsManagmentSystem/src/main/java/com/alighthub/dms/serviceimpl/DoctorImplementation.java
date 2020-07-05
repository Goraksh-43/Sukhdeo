package com.alighthub.dms.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alighthub.dms.dao.DoctorDao;
import com.alighthub.dms.dao.EmployeeDao;
import com.alighthub.dms.model.Doctor;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.service.DoctorService;


@Service
public class DoctorImplementation implements DoctorService {
	
	
	@Autowired
	private EmployeeDao employeedao;
	
	@Autowired
	private DoctorDao doctordao;

	@Override
	public void addDoctors(Doctor d) {
		// TODO Auto-generated method stub
		List<Employee> emplist=employeedao.findAll();
		List<Integer> countlist=new ArrayList<Integer>();
		System.out.println("Employee count="+countlist.size());
		
		for(Employee empcount:emplist)
		{
			countlist.add(empcount.getDrCount());
			System.out.println("Count:-"+countlist.size());
			
		}
		
		int mincount=Collections.min(countlist);
		System.out.println("Minimum count:-"+mincount);
		for(Employee emp:emplist)
		{
			if(mincount==emp.getDrCount())
			{
				d.setEmpId(emp.getEmployeeId());
				mincount=mincount+1;
				emp.setDrCount(mincount);
				employeedao.save(emp);
				break;
			}
		}
		
		doctordao.save(d);
		
	}

	@Override
	public List<Doctor> getDoctor(int empId) {
	
		
		return doctordao.findByDoctorUnderEmployee(empId);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctordao.save(doctor);
		
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctordao.findAll();
	}

	@Override
	public Doctor getDoctor(String uname, String pass) {
		// TODO Auto-generated method stub
		return doctordao.findByUnameAndPass(uname, pass);
	}

	@Override
	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		doctordao.deleteById(id);
		
	}

}
