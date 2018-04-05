package com.it.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.bos.dao.UserDao;
import com.it.bos.domain.User;
import com.it.bos.utils.MD5Utils;
import com.it.bos.web.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public User login(User user) {
		String password = MD5Utils.md5(user.getPassword());
		return userDao.getUserByAccount(user.getUsername(),password);
	}
	@Override
	public void editPassword(String id, String password) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword",password,id);
	}
	
}
