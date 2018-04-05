package main;
import web.threadlocal.dao.UserDao;
import web.threadlocal.web.User;

public class Test {
	public static void main(String[] args) {
		User u1 = new User();
		u1.setId(1);
		User u2 = new User();
		u2.setId(2);
		UserDao.Transfer(u2, u1, 2000);
	}
}
