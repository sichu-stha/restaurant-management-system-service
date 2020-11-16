package com.spring.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rms.entity.User;
import com.spring.rms.repository.UserRepository;
import com.spring.rms.utils.UserUtils;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Integer getLoggedInUserId() {
		return userRepository.getUserFromUsername(UserUtils.getUserName()).getId();
	}
	
	public User getUserFromUsername(String userName) {
		return userRepository.getUserFromUsername(userName);
	}
}
