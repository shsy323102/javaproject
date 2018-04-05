<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<User> users = User.getUsers(); 
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
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
    <table border="1" align="center">
    	<tr>
    		<td>ID</td>
    		<td>username</td>
    		<td>phone</td>
    		<td>address</td>
    		<td>date</td>
    		<td>chuli</td>
    	</tr>
    <%
    	for(Iterator<User> it = users.iterator();it.hasNext();)
    	{
    	 User u = it.next();
    	 %>
    	 <tr>
    		<td><%=u.getId() %></td>
    		<td><%=u.getUsername() %></td>
    		<td><%=u.getPhone() %></td>
    		<td><%=u.getPhone() %></td>
    		<td><%=u.getRdate() %></td>
    		<td><a href="admin/userdelete.jsp?id=<%=u.getId() %>" target="detail" onclick="return comfirm('È·ÈÏÉ¾³ı£¿')">É¾³ı</a></td>
    	</tr>
     <%
     }
    %>
    </table>
  </body>
</html>
