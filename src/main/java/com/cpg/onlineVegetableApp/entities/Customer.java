package com.cpg.onlineVegetableApp.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class Customer {
	@Id
	private int customerId;
	private String name;
	private String mobileNumber;
	private String emailid;
	private String password;
	private String confirmpassword;
	@Embedded
	private Address address;
	public Customer() {
		super();
	}
	public Customer(int customerId, String name, String mobileNumber, String emailid, String password,
			String confirmpassword, Address address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailid = emailid;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.address = address;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailid="
				+ emailid + ", password=" + password + ", confirmpassword=" + confirmpassword + ", address=" + address
				+ "]";
	}
	
	

}
