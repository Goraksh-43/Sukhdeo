package com.alighthub.dms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 
 * @author Ravindra Sonawane
 * @page Student
 * @time 08/09/2019 - 9.05 PM
 * @purpose We have created separate Student table/pojo to store student details......
 * 
 * 
 *
 */
@Entity
@Table(name="Student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Student_Id")
private int studentId;
@Column(name="Student_Fname")
private String studentFname;

@Column(name="Student_Lname")
private String studentLname;


/*@Column(name="Student_Address")
private String studentAddress;
@Column(name="Student_Department")
private String studentDepartment;*/
@Column(name="Student_MobileNo")
private int studentMobileNo;
@Column(name="Student_Gender")
private String studentGender;
@Column(name="Student_Email")
private String studentEmail;

@Column(name="Student_Status")
private String studentStatus;
@Column(name="Student_Role")
private String studentRole;

@OneToOne(cascade=CascadeType.ALL)
/*@Column(name="Login_Details")*/
private Login login;


public int getStudentId() {
	return studentId;
}

public String getStudentFname() {
	return studentFname;
}

public String getStudentLname() {
	return studentLname;
}

public int getStudentMobileNo() {
	return studentMobileNo;
}

public String getStudentGender() {
	return studentGender;
}

public String getStudentEmail() {
	return studentEmail;
}

public String getStudentStatus() {
	return studentStatus;
}

public String getStudentRole() {
	return studentRole;
}

public Login getLogin() {
	return login;
}

public Address getAddress() {
	return address;
}





public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public void setStudentFname(String studentFname) {
	this.studentFname = studentFname;
}

public void setStudentLname(String studentLname) {
	this.studentLname = studentLname;
}

public void setStudentMobileNo(int studentMobileNo) {
	this.studentMobileNo = studentMobileNo;
}

public void setStudentGender(String studentGender) {
	this.studentGender = studentGender;
}

public void setStudentEmail(String studentEmail) {
	this.studentEmail = studentEmail;
}

public void setStudentStatus(String studentStatus) {
	this.studentStatus = studentStatus;
}

public void setStudentRole(String studentRole) {
	this.studentRole = studentRole;
}

public void setLogin(Login login) {
	this.login = login;
}

public void setAddress(Address address) {
	this.address = address;
}
@OneToOne(cascade=CascadeType.ALL)
/*@Column(name="Address_Details")*/
private Address address;

/*@ManyToOne(cascade=CascadeType.ALL)
private Admin admin;

@ManyToOne(cascade=CascadeType.ALL)
private Employee employee;

@ManyToOne(cascade=CascadeType.ALL)
private Doctor doctor;*/
}
