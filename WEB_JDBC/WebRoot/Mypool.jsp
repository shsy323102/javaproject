<%@page import="com.jdbc.connect.MyDataSourse"%>
<%@page import="com.jdbc.connect.DB"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	MyDataSourse mydata = new MyDataSourse();
	Connection conn = mydata.getConnection();
	System.out.println(mydata.getSize());
	ResultSet rs = DB.getResultSet(conn,"select * from product");
	conn.close();
	System.out.println(mydata.getSize());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <%
   		while(rs.next()){
    %>
    <div><%=rs.getInt("id") %></div>
    <%
    	}
     %>
  </body>
</html>
