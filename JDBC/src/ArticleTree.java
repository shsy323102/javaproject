import java.sql.*;
public class ArticleTree {

	public static void main(String[] args) {
		new ArticleTree().show();
	}
public void show()
{
	Connection con = null;
	Statement sta = null;
	ResultSet rs = null;
	try 
	{		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
		sta=con.createStatement();
		rs=sta.executeQuery("select * from article where pid = 0");
		while(rs.next())
		{
			System.out.println(rs.getString("cont"));	
			tree(con,rs.getInt("id"),1);
		}
		
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
public void tree(Connection con,int id,int leval)
	{
		Statement sta = null;
		ResultSet rs  = null;
		StringBuffer buf = new StringBuffer("");
		for(int i =0;i<leval;i++)
		{
			buf.append("  ");
		}
		try{
			sta=con.createStatement();
			rs=sta.executeQuery("select * from article where pid = "+id );
			while(rs.next())
			{
				if(rs.getInt("isleaf")!=0)
				System.out.println(buf+rs.getString("cont"));
				tree(con,rs.getInt("id"),leval+1);
			}
			
		}
		catch (SQLException e) {	
			e.printStackTrace();	
		}
		finally
		{
			try {
				 if(rs!=null)rs.close();rs=null;
				 if(sta!=null)sta.close();sta=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
}
