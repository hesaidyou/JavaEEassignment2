package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**").permitAll();
//		 .anyRequest().authenticated();
		http
		.authorizeRequests().antMatchers("/gym/course")
		.access("hasRole('USER')");
//		.and().requestMatchers().antMatchers("/product/delete")
//		.and().authorizeRequests()
//		.antMatchers("/product/delete").access("hasRole('ADMIN')");
	}   
}
