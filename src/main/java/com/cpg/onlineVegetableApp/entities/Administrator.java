package com.cpg.onlineVegetableApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrator")
public class Administrator {
	
	@Id
	private int adminId;
	private String name;
	private String contactNumber;
	private String emailid;
	public Administrator() {
		super();
	}
	public Administrator(int adminId, String name, String contactNumber, String emailid) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailid = emailid;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "Administrator [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber
				+ ", emailid=" + emailid + "]";
	}
	

}
