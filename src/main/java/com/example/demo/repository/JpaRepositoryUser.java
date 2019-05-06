package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;


public interface JpaRepositoryUser extends JpaRepository<User, String>{

	User getByUsername(String username);
	User getByUsernameAndPassword(String username,String password);
	//Object getByPasswordAndTelephone(String password, String telephone);
}


//多表查询问题，repo里的类型设置了为user，但是多表中海油userinfo的表，代码找不到telephone怎么解决
//看代码：每个查询都需要一个类，信息量大的类包含小类，查询用大类