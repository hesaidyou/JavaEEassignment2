package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Userinfo;


public interface UserInfoService {
	List<Course> getCoursesByUsername(String username);
	Userinfo getUserInfoByUsername(String name);
}
