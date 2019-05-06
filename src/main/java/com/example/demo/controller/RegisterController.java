package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/welcome")
public class RegisterController {

	private UserService userservice;
	@Autowired
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	@RequestMapping("/register")
	public String registerPage() {
		return "/welcome/register";
	}
	
	@ResponseBody
	@RequestMapping("/register/sub")
	public String doregister(User user) {
		userservice.register(user);
		return "success";
	}
}
