package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
//@Table(name = "selectcourse",schema="springbootcrud")
@IdClass(SelectCourseId.class)
public class CourseUserinfo implements Serializable{
	@Id
	//@Column(name="username")
	private String username;
	@Id
	//@Column(name="courseid")
	private String courseid;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	
	
}
