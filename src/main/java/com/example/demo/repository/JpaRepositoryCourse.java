package com.example.demo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;

public interface JpaRepositoryCourse extends JpaRepository<Course, String> {
	public List<Course> findByCourseid(Pageable pageable);
	

}
