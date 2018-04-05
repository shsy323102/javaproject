<%@page import="com.jdbc.connect.C3p0util"%>
<%@page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<%@page import="com.mchange.v2.c3p0.DataSources"%>
<%@page import="com.jdbc.connect.DB"%>
<%@page import="java.sql.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.io.PrintWriter" %>

<%
	String username=request.getParameter("username");
	Connection conn = C3p0util.getConnection();
	//sql 注入
	String sql = "select * from user where username = '"+username+"'";
	System.out.println(sql);
	ResultSet rs = DB.getResultSet(conn,sql);
	PrintWriter output =response.getWriter();
	response.setContentType("text");
	if(false==rs.next()){
	output.print("用户名不存在");
	}
	output.close();	
%>