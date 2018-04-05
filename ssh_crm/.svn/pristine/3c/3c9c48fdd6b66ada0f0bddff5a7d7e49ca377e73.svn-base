package it.com.service.impl;
import it.com.dao.UserDao;
import it.com.domain.User;
import it.com.service.UserService;
import it.com.utils.MD5Utils;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(User u) {
			User exitU = userDao.getByUserCode(u.getUser_code());
			if(exitU==null){
				throw new RuntimeException("用户名不存在");
			}
			else if(!exitU.getUser_password().equals(MD5Utils.md5(u.getUser_password()))){
				throw new RuntimeException("密码错误");
			}
			return exitU;
	}

	@Override
	public void save(User u) {
		userDao.save(u);
	}

	@Override
	public void rejist(User user) {
		User eu= userDao.getByUserCode(user.getUser_code());
		if(eu!=null){
			throw new RuntimeException("账号已存在");
		}
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		userDao.save(user);
	}

}
