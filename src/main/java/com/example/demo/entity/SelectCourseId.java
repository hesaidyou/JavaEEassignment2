package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class SelectCourseId implements Serializable{
	//@Column(name="username")
	private String username;
	
	//@Column(name = "courseid")
	private String courseid;

}
