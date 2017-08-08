package com.eduardo.spring.service;

import java.util.List;

import com.eduardo.spring.model.User;

public interface UserService {

	List<User> getAllUsers();

	boolean userExists(User user);

	void saveUser(User user);

	User findUserbyId(long id);

	void updateUser(User user);

	
}
