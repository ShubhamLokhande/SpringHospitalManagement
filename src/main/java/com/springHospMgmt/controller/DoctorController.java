package com.springHospMgmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@PostMapping(path = {"/delete/{id}", "/active/{id}"})
	public void activeDeleteDoctor(@PathVariable(value = "id") long id, HttpServletRequest request) {
		String url = request.getServletPath();
		if(url.startsWith("/doctor/delete")) {
			docService.setStatusOfDoctor(false, id);
		} else if(url.startsWith("/doctor/active")) {
			docService.setStatusOfDoctor(true, id);
		} else {
			System.out.println("Doctor not Activated Or Deleted...");		//logger
		}
	}
	
	@PostMapping(path = "/{email}")
	public Doctor getDoctorByEmail(@PathVariable(value = "email") String email) {
		return docService.getDoctorByEmail(email);
	}
	
	@PostMapping(path = {"/listTrue", "/listFalse"})
	public List<Doctor> doctorListByStatus(HttpServletRequest request) {
		String url = request.getServletPath();
		if(url.startsWith("/doctor/listTrue")) {
			return docService.getAllDoctorList(true);
		} else if(url.startsWith("/doctor/listFalse")) {
			return docService.getAllDoctorList(false);
		} else {
			System.out.println("Unable to fetch Doctor List...");			//logger
			return null;
		}
	}
}
