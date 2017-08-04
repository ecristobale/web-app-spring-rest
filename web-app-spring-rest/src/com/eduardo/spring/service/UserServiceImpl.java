package com.eduardo.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.eduardo.spring.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final AtomicLong counterId = new AtomicLong();
	
	private static List<User> users;
	
	static {
		users = generateHardcodedUsers();
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	private static List<User> generateHardcodedUsers() {
		
		return new ArrayList<User>(){{
			add(new User(counterId.incrementAndGet(), "User1", "City1", "email1@email.com"));
			add(new User(counterId.incrementAndGet(), "User2", "City2", "email2@email.com"));
			add(new User(counterId.incrementAndGet(), "User3", "City3", "email3@email.com"));
			add(new User(counterId.incrementAndGet(), "User4", "City4", "email4@email.com"));
		}};
	}

	@Override
	public boolean userExists(User user) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equalsIgnoreCase(user.getUsername())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveUser(User user) {
		user.setId(counterId.incrementAndGet());
		users.add(user);
	}

}
