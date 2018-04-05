<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="GBK"%>
<%
	request.setCharacterEncoding("gbk");
	int id = Integer.parseInt(request.getParameter("id"));
	int rootid = Integer.parseInt(request.getParameter("rootid"));
	String cont = request.getParameter("cont");
	cont=cont.replaceAll("\n", "<br>");
	String title =request.getParameter("title");
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
	con.setAutoCommit(false);
	String sql = " insert into article values (null,?,?,?,?,now(),0)";
	PreparedStatement prstemt = con.prepareStatement(sql);
	Statement stem = con.createStatement();
	prstemt.setInt(1,id);
	prstemt.setInt(2, rootid);
	prstemt.setString(3, title);
	prstemt.setString(4, cont);
	prstemt.executeUpdate();
	stem.executeUpdate("update article set isleaf = 1 where id ="+id);
	con.commit();
	con.setAutoCommit(true);
	stem.close();
	prstemt.close();
	con.close();
	response.sendRedirect("MyJsp.jsp");
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>  replyok </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
         <%=id %> <br>
            <%=rootid %><br>
            <%=title %> <br>
            <%=cont %> <br>
         replyOK!  <br>
  </body>
</html>
