package com.eduardo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.eduardo.spring.model.User;
import com.eduardo.spring.service.UserService;

@RestController
public class UsersRestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userService.getAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT); // or not found
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		
		if(userService.userExists(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		userService.saveUser(user);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
