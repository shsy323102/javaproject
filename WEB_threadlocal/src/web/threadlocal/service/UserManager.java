package web.threadlocal.service;

import web.threadlocal.dao.UserDao;
import web.threadlocal.web.User;

public class UserManager {
	
	public static boolean putMoney(User u,double count){
		return UserDao.putMoney(u,count);
	}
	public static boolean getMoney(User u,double count){
		return UserDao.getMoney(u,count);
	}
}
