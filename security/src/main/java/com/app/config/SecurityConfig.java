package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	public PasswordEncoder passwordEncoder() {
		return new BcryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity httpsecurity) throws Exception {

		httpsecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/home/public").permitAll().anyRequest()
				.authenticated().and().formLogin();

		return httpsecurity.build();

	}
    @Bean
	public UserDetailsService userDetailsService() {
        UserDetails normaluser = User
        		.withUsername("uday")
        		.password("password")
        		.roles("ROLE_NORMAL")
        		.build();
        
        return new InMemoryUserDetailsManager(normaluser);
	}

}
