<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.zhj.shopping.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 		List<Order> orders = OrderMgr.getinstance().getorders();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <center>
  	<table border="1">
  	  <tr>
  	  	<td>id</td>
  	  	<td>userid</td>
  	  	<td>addr</td>
  	  	<td>odate</td>
  	  	<td>status</td>
  	  	<td>modify</td>
  	  </tr>
 <%
 		for(Iterator<Order> it = orders.iterator();it.hasNext();){
 		Order c = it.next();
  %>
  	<tr>
  	  	<td><%=c.getId() %></td>
  	  	<td><%=c.getUser().getId() %></td>
  	  	<td><%=c.getAddr() %></td>
  	  	<td><%=c.getOdate()%></td>
  	  	<td><%=c.getStatus() %></td>
  	  	<td><a href="ordermodify.jsp?id=<%=c.getId()%>">ĞŞ¸Ä</a></td>
  	 </tr>
 <%
 	}
  %>
  	</table>
  </center>
  </body>
</html>
