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

import com.springHospMgmt.dto.UserDTO;
import com.springHospMgmt.dtoMapper.UserDTOMapper;
import com.springHospMgmt.entity.User;
import com.springHospMgmt.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView getView(ModelAndView modelAndView) {
		modelAndView.setViewName("user");
		return modelAndView;
	}
	
	@PostMapping(path = "/save")
	public User saveUser(@RequestBody UserDTO userDTO) {
		User user = UserDTOMapper.mapToUser(userDTO);
		return userService.saveUser(user);
	}
	
	@PostMapping(path = {"/delete/{id}", "/active/{id}"})
	public void activeDeleteUser(@PathVariable(value = "id") long id, HttpServletRequest request) {
		String url = request.getServletPath();
		if(url.startsWith("/user/delete")) {
			userService.setStatusOfUser(false, id);
		} else if(url.startsWith("/user/active")) {
			userService.setStatusOfUser(true, id);
		} else {
			System.out.println("User not Activated Or Deleted...");		//logger
		}
	}
	
	@PostMapping(path = "/{email}")
	public User getUserByEmail(@PathVariable(value = "email") String email) {
		return userService.getUserByEmail(email);
	}
	
	@PostMapping(path = {"/listTrue", "/listFalse"})
	public List<User> userListByStatus(HttpServletRequest request) {
		String url = request.getServletPath();
		if(url.startsWith("/user/listTrue")) {
			return userService.getAllUserList(true);
		} else if(url.startsWith("/user/listFalse")) {
			return userService.getAllUserList(false);
		} else {
			System.out.println("Unable to fetch User List...");			//logger
			return null;
		}
	}
}
