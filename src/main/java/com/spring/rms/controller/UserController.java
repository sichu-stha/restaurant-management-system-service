package com.spring.rms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getLoggedInUser")
	private ResponseEntity<Integer> getLoggedInUser(){
		return ResponseEntity.ok(userService.getLoggedInUserId());
	}
}
