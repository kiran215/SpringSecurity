package com.example.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		
		UserDetails user = User.withDefaultPasswordEncoder()
	            .username("test")
	            .password("test@789")
	            .roles("USER")
	            .build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()
	            .username("admin")
	            .password("admin@789")
	            .roles("ADMIN")
	            .build();
	        return new InMemoryUserDetailsManager(user,admin);
	}
	
//	 @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	       	http.authorizeHttpRequests().antMatchers("/admin").hasRole("ADMIN")
	       	.antMatchers("/user").hasRole("USER")
	       	.antMatchers("/").permitAll()
	       	.and().formLogin();
			return http.build();
	       	
	 
	 }
	
	
}
