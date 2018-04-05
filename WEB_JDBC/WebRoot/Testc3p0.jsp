<%@page import="com.jdbc.connect.C3p0util"%>
<%@page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<%@page import="com.mchange.v2.c3p0.DataSources"%>
<%@page import="com.jdbc.connect.DB"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Connection conn = C3p0util.getConnection();
	ResultSet rs = DB.getResultSet(conn,"select * from product");
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
    	conn.close();
     %> 
  </body>
</html>
