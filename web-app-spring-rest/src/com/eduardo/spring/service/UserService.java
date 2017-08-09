package com.eduardo.spring.service;

import java.util.List;

import com.eduardo.spring.model.User;

public interface UserService {

	List<User> getAllUsers();

	boolean userExists(User user);

	void saveUser(User user);

	User findUserById(long id);

	void updateUser(User user);

	void deleteUserById(long id);

}
