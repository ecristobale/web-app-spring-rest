package com.eduardo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// Retrieve all users
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userService.getAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT); // or not found
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// Create user
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		if(userService.userExists(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// Update user
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		
		// retrieve user with the id received in the path
		User currentUser = userService.findUserbyId(id);
		
		if(currentUser == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		currentUser.setUsername(user.getUsername());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());
		
		// update with currentUser using service
		userService.updateUser(currentUser);
		
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
}
