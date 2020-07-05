package com.alighthub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.dms.model.Doctor;
import com.alighthub.dms.model.Employee;
import com.alighthub.dms.service.DoctorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/doctor")
public class DoctorController
{
	@Autowired
	private DoctorService doctorservice;
	
	@PostMapping("/ad")
	public String addDoctor(@RequestBody Doctor d)
	{
		doctorservice.addDoctors(d);
		return "Doctor added successfully";
	}
	
	@GetMapping("/getdoctor/{empId}")
	public List<Doctor> getDoctor(@PathVariable int empId)
	{
		return doctorservice.getDoctor(empId);
	}
	
	@PutMapping("/updatedoctor")
	public Doctor updateDoctor(@RequestBody Doctor doctor)
	{
		return doctorservice.updateDoctor(doctor);
		//return "status updated successfully";
	}
	
	@GetMapping("/getalldoctor")
	public List<Doctor> getAllDoctor()
	{
		return doctorservice.getAllDoctor();
	}
	
	
	@GetMapping("/{uname}/{pass}")
	public Doctor getDoctor(@PathVariable String uname,@PathVariable String pass)
	{
		System.out.println("get employee called");
		return doctorservice.getDoctor(uname,pass);
	}
	
	@DeleteMapping("/dele/{id}")
	public String deleteDoctor(@PathVariable int id)
	{
		doctorservice.deleteDoctor(id);
		return "Doctor Deleted Successfully";
	}

	
	
	
	
	

}
