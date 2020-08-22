package com.springHospMgmt.dtoMapper;

import java.io.Serializable;
import java.time.LocalDate;

import com.springHospMgmt.dto.DoctorDTO;
import com.springHospMgmt.entity.Doctor;

public class DoctorDTOMapper implements Serializable{

	private static final long serialVersionUID = 4024164407246653614L;

	public static Doctor mapToDoctor(DoctorDTO docDTO) {
		Doctor doctor = new Doctor();
		doctor.setName(docDTO.getName());
		doctor.setEmail(docDTO.getEmail());
		doctor.setPassword(docDTO.getPassword());
		doctor.setGender(docDTO.getGender());
		doctor.setQual(docDTO.getQual());
		doctor.setDob(LocalDate.parse(docDTO.getDob()));
		doctor.setExpertIn(docDTO.getExpertIn());
		doctor.setStatus(docDTO.isStatus());
		return doctor;
	}
}
