package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserInfo;

public interface JpaRepositoryUserInfo extends JpaRepository<UserInfo, String> {

}
