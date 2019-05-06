package com.example.demo.controller;

import java.util.Map;

import javax.persistence.Enumerated;
import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/")
public class WelcomeController {
	private UserService userservice;
	@Autowired
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	@RequestMapping("/welcome/login")
	public String login(User user, Map<String,Object> map) {
		User user1 =  userservice.getByUsernameAndPassword(user.getUsername(),user.getPassword());
		if(user1 == null){
			map.put("msg","登入失败");
			return "/welcome/login";
		}else{
			map.put("msg","登入成功");
			return "/gym/gym";
		}
	}
	
	@RequestMapping("/")
	public String welcomepage() {
		return "/index";
	}
	
	
//	@ResponseBody
//	@RequestMapping("")
//	public String welcome() {
//		return "welcome";
//	}
}
