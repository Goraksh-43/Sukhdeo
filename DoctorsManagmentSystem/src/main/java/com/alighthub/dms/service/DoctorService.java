package com.alighthub.dms.service;

import java.util.List;

import com.alighthub.dms.model.Doctor;

public interface DoctorService {

	void addDoctors(Doctor d);

	List<Doctor> getDoctor( int empid);

	Doctor updateDoctor(Doctor doctor);

	List<Doctor> getAllDoctor();

	Doctor getDoctor(String uname, String pass);

	void deleteDoctor(int id);
	

}
