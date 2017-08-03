package com.eduardo.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.spring.model.User;

@RestController
public class UsersRestController {
	
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = new ArrayList<User>();
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT); // or not found
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
