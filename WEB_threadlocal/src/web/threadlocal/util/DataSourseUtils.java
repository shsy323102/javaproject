package web.threadlocal.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourseUtils {
	private static DataSource datasource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	
	public static DataSource getDataSource(){
		return datasource;
	}
	public static Connection getConnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public  static Connection getCurrentConnection(){
		Connection conn = tl.get();
		if(conn==null){
			conn = getConnection();
			tl.set(conn);
		}
		return conn;
	}
	public static void startTransaction() throws SQLException {
		Connection conn  = getCurrentConnection();
		if(conn!=null){
			conn.setAutoCommit(false);
		}
	}
	public static void rollback() throws SQLException{
		Connection conn = getCurrentConnection();
		if(conn!=null){
			conn.rollback();
		}
	}
	public static void commitAndRelease() throws SQLException{
		Connection conn  = getCurrentConnection();
		if(conn!=null){
			conn.commit();
			conn.setAutoCommit(true);
			conn.close();
			tl.remove();
		}
	}
	public static void closeConnection() throws SQLException {
		Connection con = getCurrentConnection();
		if (con != null) {
			con.close();
		}
		
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
}
