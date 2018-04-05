<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String admin = (String)session.getAttribute("admin");
	if(admin==null||!admin.equalsIgnoreCase("true")){
	response.sendRedirect("login.jsp");
	}
 %>
