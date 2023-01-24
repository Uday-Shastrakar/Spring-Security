package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity httpsecurity) throws Exception {
		
		httpsecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/home/public")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpsecurity.build();
		
		
	}

}
