package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Coach;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.service.CoachService;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/gym")
public class GymController {
	private CourseService courseservice;
	@Autowired
	public void setCourseservice(CourseService courseservice) {
		this.courseservice = courseservice;
	}
	
	private CoachService coachservice;
	@Autowired
	public void setUserservice(CoachService coachservice) {
		this.coachservice = coachservice;
	}
	
	
	@RequestMapping("/course")
	private String course(Map<String, Object> map) {
		List<Course> course = courseservice.getAllCourse();
		map.put("courses", course);
		return "/gym/course";
	}
	
	@RequestMapping("/coach")
	private String coach(Map<String, Object> map) {
		List<Coach> coachs = coachservice.getAllCoach();
		map.put("coaches", coachs);
        
		return "/gym/coach";
	}
}
