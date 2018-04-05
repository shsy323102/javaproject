package com.jdbc.connect;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDataSourse implements DataSource{
	static LinkedList<Connection> pool= new LinkedList<Connection>();
	
	static {
		for (int i = 0; i < 5; i++) {
			Connection conn = DB.getConnection();
			MyConnection myconn = new MyConnection(conn, pool);
			pool.add(myconn);
			}
	}
	public Connection getConnection() throws SQLException {
		if(pool==null){
			for (int i = 0; i < 5; i++) {
				Connection conn = DB.getConnection();
				MyConnection myconn = new MyConnection(conn, pool);
				pool.add(myconn);
				}
		}
		Connection conn = pool.removeFirst(); 
		return conn;
	}
	public int getSize(){
		return pool.size();
	}
	public PrintWriter getLogWriter() throws SQLException {
	
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
	
		
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		
	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
	
		return null;
	}
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
	
		return false;
	}
	

	public Connection getConnection(String username, String password) throws SQLException {
		
		return null;
	}

}
