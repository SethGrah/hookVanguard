package com.skillstorm.hook.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skillstorm.hook.models.Users;
import com.skillstorm.hook.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	private static final Logger log = LoggerFactory.getLogger(GoalController.class);
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping(path = "/{username}/{password}")
	public ResponseEntity<Users> login(@PathVariable String username, @PathVariable String password){
		return new ResponseEntity<Users>(this.usersService.login(username,password),HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping
	public ResponseEntity<Users> save(@RequestBody Users user){
		return new ResponseEntity<Users>(this.usersService.add(user),HttpStatus.CREATED);
	}
}
