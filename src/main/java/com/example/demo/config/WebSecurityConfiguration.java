package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


//@SpringBootApplication
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	}
	
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	
    	UserDetails user=User.builder().username("123").password("123").
    			roles("USER").build();
//    	UserDetails user=User.builder().username("user").password(passwordEncoder.encode("secret")).
//    			roles("USER").build();
    	UserDetails userAdmin=User.builder().username("admin").password(passwordEncoder.encode("secret")).
    			roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user,userAdmin);
    }
    
//    //@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new  BCryptPasswordEncoder();
//    }
   

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
        .requestMatchers().anyRequest()
        .and()
            .authorizeRequests()
            .antMatchers("/oauth/*").permitAll();
//        http
//        	.csrf().disable()
//            .authorizeRequests()
//                //.antMatchers("/swagger-resources").permitAll()
//             	.antMatchers("/gym/course").hasRole("USER")
//            	//.antMatchers("/product/delete").hasRole("ADMIN")
//            	.and()
//                .formLogin()
//                .loginPage("/")
//                .permitAll()
//                .and()
//                .logout() // Metodo get pues he desabilitado CSRF
//                .permitAll()
                ;
    }

}
