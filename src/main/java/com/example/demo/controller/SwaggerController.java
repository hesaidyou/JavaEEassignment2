package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Boy;
import com.example.demo.entity.Course;
import com.example.demo.entity.ResObject;
import com.example.demo.entity.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户接口")
@RestController
@RequestMapping("/demoController")
public class SwaggerController {
	@Autowired
	private UserService userservice;
	@Autowired
	private UserInfoService userinfoservice;
	@Autowired
	private CourseService courseservice;
	
    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value="/createUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject createUser(@RequestBody User user){
    	userservice.register(user);
        System.out.println("createUser:::"+user.toString());
        return new ResObject(HttpStatus.OK.value(), "新增成功.");
    }
 
    
//    @ApiOperation(value = "修改用户" ,  notes="修改用户")
//    @RequestMapping(value="/updateUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
//    public ResObject updateUser(@RequestBody User user){
//    	
//        System.out.println("updateUser:::"+user.toString());
//        return new ResObject(HttpStatus.OK.value(), "修改成功.");
//    }
 
    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
    public ResObject deleteUser(@RequestParam("username") String username){
    	userservice.deleteByUsername(username);
        System.out.println("deleteUser:::"+username);
        return new ResObject(HttpStatus.OK.value(), "删除成功.");
    }
 
//    @ApiOperation(value = "查询用户" ,  notes="查询用户")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "userId", value = "用户标识", required = true, paramType = "query", dataType = "String")
//    })
//    @RequestMapping(value="/queryUser",method=RequestMethod.GET)
//    public ResObject queryUser(@RequestParam("userId") String userId){
//        System.out.println("queryUser:::"+userId);
//        Boy user = new Boy(userId, "张三", "******", "mao2080@sina.com");
//        return new ResObject(HttpStatus.OK.value(), user);
//    }
    
    @ApiOperation(value = "查询用户课程" ,  notes="查询用户课程")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户标识", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value="/queryUserCourses",method=RequestMethod.GET)
    public ResObject queryUserCourses(@RequestParam("username") String username){
        System.out.println("queryUser:::"+username);
        List<Course> mycourses = userinfoservice.getUserInfoByUsername(username).getCourses();
        return new ResObject(HttpStatus.OK.value(), mycourses);
    }
    
    
	 @ApiOperation(value = "查询全部课程" ,  notes="查询全部课程")
	 @RequestMapping(value="/queryAllCourses",method=RequestMethod.GET)
	 public ResObject queryAllCourses(){
		 List<Course> course = courseservice.getAllCourse();
	     return new ResObject(HttpStatus.OK.value(), course);
	 }
	  
}
