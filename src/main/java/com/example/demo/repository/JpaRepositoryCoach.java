package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Coach;

public interface JpaRepositoryCoach extends JpaRepository<Coach, String> {

}
