package com.springHospMgmt.dtoMapper;

import java.io.Serializable;
import java.time.LocalDate;

import com.springHospMgmt.dto.ReceptionDTO;
import com.springHospMgmt.entity.Reception;

public class ReceptionDTOMapper implements Serializable{

	private static final long serialVersionUID = -5417279024299004800L;

	public static Reception mapToReception(ReceptionDTO recepDTO) {
		Reception recep = new Reception();
		recep.setName(recepDTO.getName());
		recep.setEmail(recepDTO.getEmail());
		recep.setPassword(recepDTO.getPassword());
		recep.setGender(recepDTO.getGender());
		recep.setQual(recepDTO.getQual());
		recep.setDob(LocalDate.parse(recepDTO.getDob()));
		recep.setMobileNo(recepDTO.getMobileNo());
		recep.setStatus(recepDTO.isStatus());
		return recep;
	}
}
