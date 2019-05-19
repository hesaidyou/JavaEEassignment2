package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Coach;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.entity.Userinfo;
import com.example.demo.service.CoachService;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/gym")
public class GymController {
	private CourseService courseservice;
	@Autowired
	public void setCourseservice(CourseService courseservice) {
		this.courseservice = courseservice;
	}
	private UserInfoService userinfoservice;
	@Autowired
	public void setUserInfoservice(UserInfoService userinfoservice) {
		this.userinfoservice = userinfoservice;
	}
	
	private CoachService coachservice;
	@Autowired
	public void setCoachservice(CoachService coachservice) {
		this.coachservice = coachservice;
	}
	
	
	@RequestMapping("/course")
	private String course(Map<String, Object> map) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
		List<Course> course = courseservice.getAllCourse();
		map.put("courses", course);
		List<Course> mycourses = userinfoservice.getUserInfoByUsername("123").getCourses();
		map.put("mycourses", mycourses);
		//System.out.println("here");
		//System.out.println(userinfoservice.getUserInfoByUsername("123").getTelephone());
		return "/gym/course";
	}
	
	@RequestMapping("/coach")
	private String coach(Map<String, Object> map) {
		List<Coach> coachs = coachservice.getAllCoach();
		map.put("coaches", coachs);
        
		return "/gym/coach";
	}
}
