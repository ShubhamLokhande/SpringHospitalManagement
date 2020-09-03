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

import com.springHospMgmt.dto.ReceptionDTO;
import com.springHospMgmt.dtoMapper.ReceptionDTOMapper;
import com.springHospMgmt.entity.Reception;
import com.springHospMgmt.service.ReceptionService;

@RestController
@RequestMapping("/reception")
public class ReceptionController {

	@Autowired
	private ReceptionService recepService;
	
	@GetMapping
	public ModelAndView getView(ModelAndView modelAndView) {
		modelAndView.setViewName("reception");
		return modelAndView;
	}
	
	@PostMapping(path = "/save")
	public Reception saveReception(@RequestBody ReceptionDTO userDTO) {
		Reception user = ReceptionDTOMapper.mapToReception(userDTO);
		return recepService.saveReception(user);
	}
	
	@PostMapping(path = {"/delete/{id}", "/active/{id}"})
	public void activeDeleteReception(@PathVariable(value = "id") long id, HttpServletRequest request) {
		String url = request.getServletPath();
		if(url.startsWith("/reception/delete")) {
			recepService.setStatusOfReception(false, id);
		} else if(url.startsWith("/reception/active")) {
			recepService.setStatusOfReception(true, id);
		} else {
			System.out.println("Reception not Activated Or Deleted...");		//logger
		}
	}
	
	@PostMapping(path = "/{email}")
	public Reception getReceptionByEmail(@PathVariable(value = "email") String email) {
		return recepService.getReceptionByEmail(email);
	}
	
	@PostMapping(path = {"/listTrue", "/listFalse"})
	public List<Reception> userListByStatus(HttpServletRequest request) {
		String url = request.getServletPath();
		if(url.startsWith("/reception/listTrue")) {
			return recepService.getAllReceptionList(true);
		} else if(url.startsWith("/reception/listFalse")) {
			return recepService.getAllReceptionList(false);
		} else {
			System.out.println("Unable to fetch Reception List...");			//logger
			return null;
		}
	}
}
