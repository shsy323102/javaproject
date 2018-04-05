package web.threadlocal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import web.threadlocal.service.UserManager;
import web.threadlocal.util.DataSourseUtils;
import web.threadlocal.web.User;

public class UserDao {

	public static boolean putMoney(User u,double count) {
		int id = u.getId();
		Connection conn = DataSourseUtils.getCurrentConnection();
		String sql = "update account set money=money-"+count+" where id = "+id;
		QueryRunner runner = new QueryRunner();
		try {
			runner.update(conn,sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean getMoney(User u,double count) {
		int id = u.getId();
		
		String sql = "update account set money=money+"+count+" where id = "+id;
		QueryRunner runner = new QueryRunner();
		Connection conn = DataSourseUtils.getCurrentConnection();
		try {
			runner.update(conn,sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	public static void Transfer(User u1,User u2,double count){
		try {
			DataSourseUtils.startTransaction();
			UserManager.putMoney(u1, count);
			UserManager.getMoney(u2, count);
		} catch (Exception e) {
			try {
				DataSourseUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				DataSourseUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
