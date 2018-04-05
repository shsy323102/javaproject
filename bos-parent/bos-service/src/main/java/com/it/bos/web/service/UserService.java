package com.it.bos.web.service;

import com.it.bos.domain.User;

public interface UserService {

	User login(User user);

	void editPassword(String id, String password);

}
