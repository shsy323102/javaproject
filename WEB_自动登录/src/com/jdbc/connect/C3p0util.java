package com.jdbc.connect;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0util {
	private static ComboPooledDataSource datasourse;
	public static ComboPooledDataSource getPoolDataSource(){
		 datasourse = new ComboPooledDataSource();
		return datasourse;
	}
	public  static Connection getConnection(){
		try {
			return getPoolDataSource().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
