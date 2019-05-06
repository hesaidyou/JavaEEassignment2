package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.JpaRepositoryUser;

import net.bytebuddy.asm.Advice.This;

@Service
public class UserServiceImpl implements UserService{

	private JpaRepositoryUser jpaRepositoryDAO;
	@Autowired
	public void setJpaRepositoryDAO(JpaRepositoryUser jpaRepositoryDAO) {
		this.jpaRepositoryDAO = jpaRepositoryDAO;
	}

	
	@Override
	@Cacheable
	public List<User> getAllUsers() {
		return this.jpaRepositoryDAO.findAll();
	}
	
	@Override
	@Cacheable
	public User getUserByUsername(String username) {
		return this.jpaRepositoryDAO.getByUsername(username);
	}

	@Override
	public User register(User user) {
		return this.jpaRepositoryDAO.save(user);
	}

	@Override
	@Cacheable
	public String login(User user) {
		this.jpaRepositoryDAO.getByUsernameAndPassword(user.getUsername(),user.getPassword());
		return "success";
	}

	@Override
	@Cacheable
	public User getByUsernameAndPassword(String username,String password) {
		return this.jpaRepositoryDAO.getByUsernameAndPassword(username,password);
	}

}
