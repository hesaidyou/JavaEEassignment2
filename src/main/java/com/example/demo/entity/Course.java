package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
//@Table(name = "course",schema="springbootcrud")
public class Course {
	@Id
	private String courseid;
	private String coursename;
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)//mappedBy = "courses", 
	//private List<Userinfo> userinfo;
	//course已经被控反转了，不应该有被管理的信息，不该有userinfo

	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
//	public List<Userinfo> getUserinfos() {
//		return userinfo;
//	}
//	public void setUserInfos(List<Userinfo> userinfos) {
//		this.userinfo = userinfos;
//	}
	

}
