package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.JoinColumn;


@Entity
public class User {
	@TableGenerator(table="user", name = "user_gen")
	@Id
    private String username;
    private String password;
    
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "course", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "courseid"))
	private List<Course> courses;
    
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
