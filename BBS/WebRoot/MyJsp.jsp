<%@ page import="com.mysql.jdbc.Statement.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=gbk" %>

<%!
	String str="";
	private void tree(Connection conn,int id,int leval)
	{
	String str2="";
	Statement stem =null;
	ResultSet rs = null;
	try
	{
	 stem=conn.createStatement();
	 rs=stem.executeQuery("select * from article where pid="+id);
	 for(int i=0;i<leval;i++)
	 {
	 	str2+="&nbsp&nbsp&nbsp&nbsp&nbsp";
	 }
	 while(rs.next())
	 {
	 	str+="<tr><td>"+rs.getInt("id")+"</td><td>"+str2+"<a href='showartitle.jsp?id="+rs.getInt("id")+"'>"+
	 	rs.getString("title")+"</a></td>"+"<td><a href='delete.jsp?id="+rs.getInt("id")+"&pid="+rs.getInt("pid")+"'>É¾³ý</a>"+"</td></tr>";
	 	if(rs.getInt("isleaf")!=0)
	 	{
	 		tree(conn,rs.getInt("id"),leval+1);
	 	}
	 }
	}catch(SQLException e)
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
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
	Statement stem=con.createStatement();
	ResultSet rs=stem.executeQuery("select * from article where pid = 0");
	while(rs.next())
	{
		str+="<tr><td>"+rs.getInt("id")+"</td><td>"+"<a href='showartitle.jsp?id="+rs.getInt("id")+"'>"+
	 	rs.getString("title")+"</a></td>"+"<td><a href='delete.jsp?id="+rs.getInt("id")+"&pid="+rs.getInt("pid")+"'>É¾³ý</a>"+"</td></tr>";
	if(rs.getInt("isleaf")!=0)
	 	{
	 		tree(con,rs.getInt("id"),1);
	 	}
	 }	
	rs.close(); 
	stem.close();
	con.close();	
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
  <a href = "post.jsp">·¢±íÐÂÌû</a>
 <table border="2">
 	<%= str %>
 </table>
 <% str="";
  %>
  </body>
</html>
