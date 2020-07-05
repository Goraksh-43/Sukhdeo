package com.alighthub.dms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;
/*
 * 
 * @author Ravindra Sonawane
 * @time 9.26 PM
 * @purpose To manage employee and can view any user information activate/deactivate
 *
 */
@Entity
@Table(name="Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="Admin_Id")
	private int adminId;
	@Column(name="Admin_Fname")
	private String adminFname;
	@Column(name="Admin_Lname")
	private String adminLname;
	@Column(name="Admin_Email")
	private String adminEmail;
	
	public int getAdminId() {
		return adminId;
	}

	public String getAdminFname() {
		return adminFname;
	}

	public String getAdminLname() {
		return adminLname;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public String getAdminMobileNo() {
		return adminMobileNo;
	}

	

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public Address getAddress() {
		return address;
	}

	public Login getLogin() {
		return login;
	}	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public void setAdminFname(String adminFname) {
		this.adminFname = adminFname;
	}

	public void setAdminLname(String adminLname) {
		this.adminLname = adminLname;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public void setAdminMobileNo(String adminMobileNo) {
		this.adminMobileNo = adminMobileNo;
	}

	
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	

	

	@Column(name="Admin_MobileNo")
	private String adminMobileNo;
	
	@Column(name="Admin_Status")
	private String adminStatus;
	
	@Column(name="Admin_Role")
	private String adminRole;
	
	@Column(name="Admin_Gender")
	private String adminGender;
	@OneToMany(cascade=CascadeType.ALL)
	/*@Column(name="Employee_List")*/
	private List<Employee> employeeList=new ArrayList<Employee>();
	
	@OneToOne(cascade=CascadeType.ALL)
	/*@Column(name="Address_Details")*/
	private Address address;
	@OneToOne(cascade=CascadeType.ALL)
	/*@Column(name="Login_Id")*/
	private Login login;
	
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="admin")
	private List<Doctor> doctorList=new ArrayList<>();*/
	
	/*@OneToMany(cascade=CascadeType.ALL)
	private List<Employee> employeList=new ArrayList<>();*/
	
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="admin")
	private List<Nurse> nurseList=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="admin")
	private List<Student> studentList=new ArrayList<>();*/
	
	
}
