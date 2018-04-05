<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	Cookie cookie_username = new Cookie("cookie_username", "12345");
	Cookie cookie_password = new Cookie("cookie_password", "678910");
	cookie_username.setMaxAge(60 * 60);
	cookie_password.setMaxAge(60 * 60);
	cookie_username.setPath(request.getContextPath());
	cookie_password.setPath(request.getContextPath());
	System.out.println(request.getContextPath());
	response.addCookie(cookie_username);
	response.addCookie(cookie_password);
	
%>