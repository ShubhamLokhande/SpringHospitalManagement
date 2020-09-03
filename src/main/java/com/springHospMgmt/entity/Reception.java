package com.springHospMgmt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reception_tbl")
public class Reception {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RECEP_ID")
	private long recepId;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "GENDER", nullable = true)
	private String gender;
	
	@Column(name = "QUALIFICATION", nullable = false)
	private String qual;
	
	@Column(name = "DATE_OF_BIRH", nullable = false)
	private LocalDate dob;
	
	@Column(name = "MOBILE_NO", nullable = false)
	private String mobileNo;

	@Column(name = "STATUS", nullable = true)
	private boolean status;

	public long getRecepId() {
		return recepId;
	}
	public void setRecepId(long recepId) {
		this.recepId = recepId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reception [recepId=" + recepId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", qual=" + qual + ", dob=" + dob + ", mobileNo=" + mobileNo + ", status="
				+ status + "]";
	}	
}
