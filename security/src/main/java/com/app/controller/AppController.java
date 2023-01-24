package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class AppController {

	@GetMapping("/normal")
	public ResponseEntity<String> normalUser(){
		return ResponseEntity.ok().body("i am normal user");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok().body("i am admin user");
	}
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok().body("i am public user");
	}
	
}
