<%@page import="java.sql.Timestamp"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.zhj.shopping.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	User u = (User)session.getAttribute("User");
	String addr = request.getParameter("addr");
	if(u==null){
	  u = new User();
	  u.setId(-1);
	}
	CaryList carylist = (CaryList)session.getAttribute("carylist");
	Order o = new Order();
	o.setUser(u);
	o.setAddr(addr);
	o.setCarylist(carylist);
	o.setOdate(new Timestamp(System.currentTimeMillis()));
	o.setStatus(0);
	OrderMgr.getinstance().save(o);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    
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
   <center>Thank !</center>
  </body>
</html>
