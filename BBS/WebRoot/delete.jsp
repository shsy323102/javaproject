<%@ page import="com.mysql.jdbc.Statement.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>
<%!
	private void delete(Connection conn,int id)
	{
	Statement stem =null;
	ResultSet rs = null;
	try{
	
		 stem=conn.createStatement();
		 rs=stem.executeQuery("select * from article where pid="+id);
	
	 		while(rs.next())
		 {
	 		delete(conn,rs.getInt("id"));
	 	}
			 stem.executeUpdate("delete from article where id="+id);
	}
	catch(SQLException e)
	{
		System.out.print("1");
	}
	finally
	{
		try {
		if(rs!=null)
		{
			rs.close();
			rs=null;
		}
		if(stem!=null)
		{
		stem.close();
		stem=null;
		}
		}catch(SQLException e)
		{
		System.out.print("2");
		}
	}
}
%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	int pid = Integer.parseInt(request.getParameter("pid"));
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
	con.setAutoCommit(false);
	delete(con,id);
	Statement stem=con.createStatement();
	ResultSet rs=stem.executeQuery("select count(*) from article where pid = "+pid);
	rs.next();
	int count = rs.getInt(1);
	rs.close();
	stem.close();
	if(count<=0)
	{
		Statement statement = con.createStatement();
		statement.executeUpdate("update article set isleaf = 0 where id ="+ pid);
		statement.close();
	}
	con.commit();
	con.setAutoCommit(true);
	con.close();
	response.sendRedirect("MyJsp.jsp");	
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Article Tree</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body>
 
  </body>
</html>
