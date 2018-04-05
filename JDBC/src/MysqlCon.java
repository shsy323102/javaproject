import java.sql.*;
public class MysqlCon {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		try {		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost/mydate?user=root&password=root");
			sta=con.prepareStatement("insert into dept values (?,?,?);");
			sta.setInt(1,60);
			sta.setString(2,"A");
			sta.setString(3,"A");
			sta.executeUpdate();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {	
			e.printStackTrace();	
		}
		catch (InstantiationException e) {	
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				 if(rs!=null)rs.close();rs=null;
				 if(sta!=null)sta.close();sta=null;
				 if(con!=null)con.close();con=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
	}

}
