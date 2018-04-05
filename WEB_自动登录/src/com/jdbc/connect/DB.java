package com.jdbc.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DB {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("db");
		driver=bundle.getString("driver");
		url=bundle.getString("url");
		username=bundle.getString("username");
		password=bundle.getString("password");
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static Statement getStatement(Connection conn){
		Statement stat = null;
		if(conn!=null){
			try {
			 stat = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stat;
	}
	public static ResultSet getResultSet(Statement stat,String sql){
		ResultSet rs = null;
		if(stat!=null){
			try {
				rs = stat.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	public static ResultSet getResultSet(Connection conn,String sql){
		ResultSet rs = null;
		if(conn!=null){
			try {
				Statement stat = conn.createStatement();
				
				rs = stat.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeStatement(Statement stat){
		if(stat!=null){
			try {
				stat.close();
				stat=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void executeUpdate(Connection conn,String sql){
		Statement stat =  null;
		if(conn!=null){
			try {
				stat=conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				closeStatement(stat);
			}
			
		}
	}
	public static void executeUpdate(Statement stat,String sql){
		if(stat!=null){
			try {
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				closeStatement(stat);
			}
			
		}
	}
	public static PreparedStatement getPreStatement(Connection conn,  String sql) {
		PreparedStatement pstat = null; 
		try {
			if(conn != null) {
				pstat = conn.prepareStatement(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstat;
	}
	
	public static PreparedStatement getPreStatement(Connection conn,  String sql, int autoGenereatedKeys) {
		PreparedStatement pstat = null; 
		try {
			if(conn != null) {
				pstat = conn.prepareStatement(sql, autoGenereatedKeys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstat;
	}
	public static void close(Statement stat) {
		try {
			if(stat != null) {
				stat.close();
				stat = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
