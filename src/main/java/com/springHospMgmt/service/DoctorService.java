package com.springHospMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springHospMgmt.entity.Doctor;
import com.springHospMgmt.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository docRepo;

	@Transactional(readOnly = true)
	public List<Doctor> getAllDoctorList(boolean status) {
		return docRepo.getDoctorByStatus(status);
	}
	
	@Transactional
	public Doctor saveDoctor(Doctor doctor) {
		Doctor check = docRepo.getDoctorByEmail(doctor.getEmail());
		if(check != null) {
			doctor.setDoctorId(check.getDoctorId());
		}
		doctor.setStatus(true);
		return docRepo.save(doctor); 
	}
	
	@Transactional
	public void setStatusOfDoctor(boolean status, long doctorId) {
		docRepo.setStatusForDoctorId(status, doctorId);
	}

	@Transactional(readOnly = true)
	public Doctor getDoctorByEmail(String email) {
		Doctor doctor = docRepo.getDoctorByEmail(email);
		return doctor;
	}
}
