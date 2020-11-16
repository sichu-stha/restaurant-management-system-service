package com.spring.rms.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.rms.entity.User;
import com.spring.rms.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

}
