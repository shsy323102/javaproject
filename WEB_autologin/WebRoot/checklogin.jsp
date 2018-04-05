<%@page import="java.net.URLEncoder"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.jdbc.connect.C3p0util"%>
<%@page import="com.mchange.v2.c3p0.ComboPooledDataSource"%>
<%@page import="com.mchange.v2.c3p0.DataSources"%>
<%@page import="com.jdbc.connect.DB,com.web.User"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintWriter" %>

<%
	request.setCharacterEncoding("UTF-8");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	Connection conn = C3p0util.getConnection();
	String sql = "select * from user where username= ? and password= ?";
	PreparedStatement prstat = DB.getPreStatement(conn,sql);
	prstat.setString(1,username);
	prstat.setString(2,password);
	ResultSet rs = prstat.executeQuery();
		if(false==rs.next()){
			out.print("用户名或账户错误");
		}else {
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			String usernamecode=URLEncoder.encode(username,"UTF-8");
			Cookie cookie_username = new Cookie("cookie_username",usernamecode);
			Cookie cookie_password= new Cookie("cookie_password",u.getPassword());
			cookie_username.setMaxAge(60*60);
			cookie_password.setMaxAge(60*60);
			cookie_username.setPath(request.getContextPath());
			cookie_password.setPath(request.getContextPath());
			System.out.println(request.getContextPath());
			response.addCookie(cookie_username);
			response.addCookie(cookie_password);
			session.setAttribute("User", u);
			response.sendRedirect("index.jsp");
		}
%>