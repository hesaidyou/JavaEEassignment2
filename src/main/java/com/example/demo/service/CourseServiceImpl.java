package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repository.JpaRepositoryCourse;


@Service
public class CourseServiceImpl implements CourseService {
	private JpaRepositoryCourse jrcourse;
	@Autowired
	public void setJpaRepositoryDAO(JpaRepositoryCourse jrcourse) {
		this.jrcourse = jrcourse;
	}

	@Cacheable
	public  List<Course> getAllCourse(){
		return jrcourse.findAll();
	}
}
