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
 * @page Address
 * @time 08/09/2019 - 9.05 PM
 * @purpose We have created separate address table/pojo to store all users 
 *  address details
 * 
 *
 */
@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Address_Id")
	private int addressId;
	@Column(name="Address_Area")
	private String addressArea;
	@Column(name="Address_City")
	private String addressCity;
	@Column(name="Address_State")
	private String addressState;
	@Column(name="Address_Pincode")
	private int addressPincode;
	public int getAddressId() {
		return addressId;
	}
	public String getAddressArea() {
		return addressArea;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public int getAddressPincode() {
		return addressPincode;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public void setAddressPincode(int addressPincode) {
		this.addressPincode = addressPincode;
	}
	
	

}
