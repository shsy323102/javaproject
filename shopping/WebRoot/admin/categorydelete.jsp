<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
 		String strid = request.getParameter("id");
 		String strpid = request.getParameter("pid");
 		String strisleaf = request.getParameter("isleaf");
 		if(strid!=null&&strpid!=null&strisleaf!=null){
 		int id =Integer.parseInt(strid);
 		int pid=Integer.parseInt(strpid);
 		boolean isleaf = Boolean.parseBoolean(strisleaf);
 		Category.delete(id,pid,isleaf);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    

  </head>
  <body>
  	<center> category already delete!</center>
 		<a href="categorylist.jsp">∑µªÿ¡–±Ì</a>
  </body>
</html>		
 <% 	
 	} 
 	else{
 			out.println("error");
 	}
  %>
 

