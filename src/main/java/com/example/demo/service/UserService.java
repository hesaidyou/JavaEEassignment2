package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	//还未使用
	User getUserByUsername(String username);
	User register(User user);
	String login(User user);
	User getByUsernameAndPassword(String username,String password);
}
