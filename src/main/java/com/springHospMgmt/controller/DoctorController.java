package com.springHospMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springHospMgmt.dto.DoctorDTO;
import com.springHospMgmt.dtoMapper.DoctorDTOMapper;
import com.springHospMgmt.entity.Doctor;
import com.springHospMgmt.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService docService;
	
	@GetMapping
	public ModelAndView getView(ModelAndView modelAndView) {
		modelAndView.setViewName("doctor");
		return modelAndView;
	}
	
	@PostMapping(path = "/save")
	public Doctor insertDoctor(@RequestBody DoctorDTO docDTO) {
		Doctor doctor = DoctorDTOMapper.mapToDoctor(docDTO);
		return docService.saveDoctor(doctor);
	}
	
	@PostMapping(path = "/delete/{id}")
	public void deleteDoctor(@PathVariable(value = "id") long id) {
		docService.setStatusOfDoctor(false, id);
	}
	
	@PostMapping(path = "/active/{id}")
	public void activeDoctor(@PathVariable(value = "id") long id) {
		docService.setStatusOfDoctor(true, id);
	}
	
	@PostMapping(path = "/{email}")
	public Doctor getDoctorByEmail(@PathVariable(value = "email") String email) {
		return docService.getDoctorByEmail(email);
	}
	
	@PostMapping(path = "/listTrue")
	public List<Doctor> doctorListByTrue() {
		return docService.getAllDoctorList(true);
	}
	
	@PostMapping(path = "/listFalse")
	public List<Doctor> doctorListByFalse() {
		return docService.getAllDoctorList(false);
	}
}
