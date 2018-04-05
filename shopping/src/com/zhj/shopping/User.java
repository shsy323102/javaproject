package com.zhj.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private int id;

	private String username;

	private String password;

	private String phone;

	private String addr;

	private Date rdate;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void save() {
		Connection conn = DB.getConn();
		String sql = "insert into user values (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);
			pstmt.setTimestamp(5, new Timestamp(rdate.getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}

	}
	public static User getUser(String username) {
		User u =  null;
		Connection conn = DB.getConn();
		String sql = "select * from user where username='"+username+"'";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			 if(rs.next())
			 {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return u;
	}

	public static List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		Connection conn = DB.getConn();
		String sql = "select * from user";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return users;
	}

	public static void deleteUser(int id) {
		Connection conn = null;
		Statement stem = null;
		try {
			conn = DB.getConn();
			stem = conn.createStatement();
			String sql = "delete from user where id = " + id;
			stem.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(stem);
			DB.close(conn);
		}

	}
	public static boolean checkUsername(String username) {
		String sql = "select * from user where username=+'" + username + "'";
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			rs = DB.getResultSet(conn, sql);
			if (rs.next() == true) {
				return true;
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return false;
	}
	public static boolean checkPassword(String username,String password) {
		String sql = "select * from user where username=+'" + username + "'";
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			rs = DB.getResultSet(conn, sql);
			if (rs.next() == true) 
			{
				if(rs.getString("password").equals(password))
				{
					return true;
				}
			}
		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		return false;
	}
	public void upDate(){
		Connection conn = DB.getConn();
		String sql = "update user set username =?,phone =?,addr =? where id ="+this.id;
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}

	}
}
