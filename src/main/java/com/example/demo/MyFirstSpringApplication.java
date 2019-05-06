package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.repository.JpaRepositoryUser;

@EnableCaching
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackageClasses = JpaRepositoryUser.class)
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringApplication.class, args);
	}

}
