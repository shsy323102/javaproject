package it.com.service.impl;

import it.com.dao.UserDao;
import it.com.dao.impl.UserDaolmpl;
import it.com.domain.User;
import it.com.service.UserService;
import it.com.utils.HibernateUtils;

public class UserServiceImp implements UserService {
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User login(User user) {
		HibernateUtils.getCurrentSession().beginTransaction();
		User exitU = userDao.getByUserCode(user.getUser_code());
		HibernateUtils.getCurrentSession().getTransaction().commit();
		if(exitU==null){
			throw new RuntimeException("usercode not exit!");
		}
		if(!exitU.getUser_password().equals(user.getUser_password())){
			throw new RuntimeException("password not correct!");
		}
		
		return exitU;
	}

}
