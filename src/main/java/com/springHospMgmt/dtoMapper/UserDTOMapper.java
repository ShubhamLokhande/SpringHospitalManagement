package com.springHospMgmt.dtoMapper;

import java.io.Serializable;
import java.time.LocalDate;

import com.springHospMgmt.dto.UserDTO;
import com.springHospMgmt.entity.User;

public class UserDTOMapper implements Serializable{

	private static final long serialVersionUID = 6323565280271612187L;

	public static User mapToUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setGender(userDTO.getGender());
		user.setQual(userDTO.getQual());
		user.setDob(LocalDate.parse(userDTO.getDob()));
		user.setMobileNo(userDTO.getMobileNo());
		user.setAddress(userDTO.getAddress());
		user.setStatus(userDTO.isStatus());
		return user;
	}
}
