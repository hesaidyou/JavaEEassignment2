package com.example.demo.entity;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
//@Table(name = "userinfo",schema="springbootcrud")
public class Userinfo {
	
	@Id
	private String username;
	private String sex;
	private String telephone;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(name="course_userinfo",joinColumns = @JoinColumn(name="username",referencedColumnName="username"),inverseJoinColumns = @JoinColumn(name = "courseid",referencedColumnName="courseid"))
	private List<Course> courses;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
