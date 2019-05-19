package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Userinfo;
import com.example.demo.repository.JpaRepositoryUser;
import com.example.demo.repository.JpaRepositoryUserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	private JpaRepositoryUserInfo jpaRepository;
	@Autowired
	public void setJpaRepositoryDAO(JpaRepositoryUserInfo jpaRepository) {
		this.jpaRepository = jpaRepository;
	}
	
	@Override
	public List<Course> getCoursesByUsername(String username) {
		return this.jpaRepository.getByUsername(username).getCourses();
	}

	@Override
	public Userinfo getUserInfoByUsername(String username) {
		return this.jpaRepository.getByUsername(username);
	}
}
