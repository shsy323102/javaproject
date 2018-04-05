<%@page import="com.zhj.shopping.*" %>
<%
	User u =(User)session.getAttribute("User");
	if(u==null)
	{
		out.print("please login in!");
		return;
	}
%>