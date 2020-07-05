package com.alighthub.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * 
 * @author Ravindra Sonawane
 * @page Login
 * @time 08/09/2019 - 9.05 PM
 * @purpose Save user_Id and Password of all users admin/student/doctor/nurse/employee
 * 
 *
 */
@Entity
@Table(name="Login")
public class Login {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="Login_Id")
private int loginId;
@Column(name="Login_Uname")
private String loginuname;
@Column(name="Login_Password")
private String loginpassword;

public String getLoginuname() {
	return loginuname;
}



public String getLoginpassword() {
	return loginpassword;
}



public void setLoginuname(String loginuname) {
	this.loginuname = loginuname;
}



public void setLoginpassword(String loginpassword) {
	this.loginpassword = loginpassword;
}



@Column(name="Login_Type")
private String loginType;

public int getLoginId() {
	return loginId;
}



public String getLoginType() {
	return loginType;
}

public void setLoginId(int loginId) {
	this.loginId = loginId;
}



public void setLoginType(String loginType) {
	this.loginType = loginType;
}


}
