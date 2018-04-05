package it.com.service;

import it.com.domain.User;

public interface UserService {
	User login(User user);
	
	void save(User u);

	void rejist(User user);
}
