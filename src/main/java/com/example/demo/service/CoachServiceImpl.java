package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Coach;
import com.example.demo.repository.JpaRepositoryCoach;

@Service
public class CoachServiceImpl implements CoachService {

	private JpaRepositoryCoach jpaRepository;
	@Autowired
	public void setJpaRepositoryDAO(JpaRepositoryCoach jpaRepository) {
		this.jpaRepository = jpaRepository;
	}
	
	@Override
	@Cacheable
	public List<Coach> getAllCoach() {
		return this.jpaRepository.findAll();
	}
	
}
