<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
 		String strid = request.getParameter("productid");
 		if(ProductMgr.getinstance().deleteProductById(Integer.parseInt(strid))){
 %>		
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    

  </head>
  <body>
  	<center> product already delete!</center>
 		<a href="productlist.jsp">∑µªÿ¡–±Ì</a>
  </body>
</html>		
 <% 	
 	} 
 	else{
 			out.println("error");
 	}
  %>
 

