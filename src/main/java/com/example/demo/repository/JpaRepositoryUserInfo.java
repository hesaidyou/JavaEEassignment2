package com.example.demo.repository;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Userinfo;



public interface JpaRepositoryUserInfo extends JpaRepository<Userinfo, String> {

	Userinfo getByUsername(String username);
	
}
