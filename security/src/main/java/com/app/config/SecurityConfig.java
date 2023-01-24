package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity httpsecurity) throws Exception {

		httpsecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/home/public").permitAll().anyRequest()
				.authenticated().and().formLogin();

		return httpsecurity.build();

	}
    @Bean
	public UserDetailsService userDetailsService() {
        UserDetails normalUser = User
        		.withUsername("uday")
        		.password("password")
        		.roles("NORMAL")
        		.build();
        UserDetails adminUser = User
        		.withUsername("admin")
        		.password("admin")
        		.roles("ADMIN")
        		.build();
        
        return new InMemoryUserDetailsManager(normalUser,adminUser);
	}

}
