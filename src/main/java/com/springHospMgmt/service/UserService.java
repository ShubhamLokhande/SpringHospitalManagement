package com.springHospMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springHospMgmt.entity.User;
import com.springHospMgmt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	@Transactional(readOnly = true)
	public List<User> getAllUserList(boolean status) {
		return userRepo.getUserByStatus(status);
	}
	
	@Transactional
	public User saveUser(User user) {
		User check = getUserByEmail(user.getEmail());
		if(check != null) {
			user.setUserId(check.getUserId());
		}
		user.setStatus(true);
		return userRepo.save(user); 
	}
	
	@Transactional
	public void setStatusOfUser(boolean status, long userId) {
		userRepo.setStatusForUserId(status, userId);
	}

	@Transactional(readOnly = true)
	public User getUserByEmail(String email) {
		User user = userRepo.getUserByEmail(email);
		return user;
	}

}
