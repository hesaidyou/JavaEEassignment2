package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.example.demo.repository.JpaRepositoryUser;

@EnableCaching
@EnableAuthorizationServer
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackageClasses = JpaRepositoryUser.class)
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringApplication.class, args);
	}

}



//http://localhost:8080/oauth/authorize?response_type=code&client_id=client&scope=client&redirect_uri=http://localhost:8080
//http://localhost:8080/oauth/token?username=123&password=123&grant_type=password&scope=client&client_id=client&client_secret=123
//{"access_token":"7d998eec-dbc1-4c07-a255-f25454b21ce5","token_type":"bearer","refresh_token":"cbf23932-b63e-4559-b794-4f48b3103af5","expires_in":43035,"scope":"read write"}
//http://localhost:8080/gym/course?access_token=7d998eec-dbc1-4c07-a255-f25454b21ce5
//f3d29f84-4fa1-4694-8d75-8a07aa08fdb2