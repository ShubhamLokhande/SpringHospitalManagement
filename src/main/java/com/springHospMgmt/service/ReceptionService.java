package com.springHospMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springHospMgmt.entity.Reception;
import com.springHospMgmt.repository.ReceptionRepository;

@Service
public class ReceptionService {

	@Autowired
	ReceptionRepository recepRepo;

	@Transactional(readOnly = true)
	public List<Reception> getAllReceptionList(boolean status) {
		return recepRepo.getReceptionByStatus(status);
	}
	
	@Transactional
	public Reception saveReception(Reception recep) {
		Reception check = getReceptionByEmail(recep.getEmail());
		if(check != null) {
			recep.setRecepId(check.getRecepId());
		}
		recep.setStatus(true);
		return recepRepo.save(recep); 
	}
	
	@Transactional
	public void setStatusOfReception(boolean status, long userId) {
		recepRepo.setStatusForRecepId(status, userId);
	}

	@Transactional(readOnly = true)
	public Reception getReceptionByEmail(String email) {
		Reception recep = recepRepo.getReceptionByEmail(email);
		return recep;
	}
}