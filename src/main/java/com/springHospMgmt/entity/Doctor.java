package com.springHospMgmt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_tbl")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOC_ID")
	private long doctorId;
	
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
	
	@Column(name = "EXPERT_IN", nullable = false)
	private String expertIn;
	
	@Column(name = "STATUS", nullable = true)
	private boolean status;
//	
//	@Column(name = "CREATED_ON", nullable = true)
//	private LocalDateTime createdOn;
//	
//	@Column(name = "UPDATED_ON", nullable = true)
//	private LocalDateTime updatedOn; 
	
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
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
	public String getExpertIn() {
		return expertIn;
	}
	public void setExpertIn(String expertIn) {
		this.expertIn = expertIn;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
//	public LocalDateTime getCreatedOn() {
//		return createdOn;
//	}
//	public void setCreatedOn(LocalDateTime createdOn) {
//		this.createdOn = createdOn;
//	}
//	public LocalDateTime getUpdatedOn() {
//		return updatedOn;
//	}
//	public void setUpdatedOn(LocalDateTime updatedOn) {
//		this.updatedOn = updatedOn;
//	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", qual=" + qual + ", dob=" + dob + ", expertIn=" + expertIn + ", status="
				+ status + "]";
	}
//	@PrePersist
//	public void preSave() {
//		setCreatedOn(LocalDateTime.now());
//		setUpdatedOn(LocalDateTime.now());
//	}
//	@PreUpdate
//	public void preUpdate() {
//		setUpdatedOn(LocalDateTime.now());
//	}
}
