<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page contentType="text/html; charset=gbk" %>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("gbk");
	String action = request.getParameter("action");
	if(action != null && action.equals("post"))
{
	String cont = request.getParameter("cont");
	cont=cont.replaceAll("\n", "<br>");
	String title =request.getParameter("title");
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
	con.setAutoCommit(false);
	String sql = " insert into article values (null,0,?,?,?,now(),0)";
	PreparedStatement prstemt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	Statement stem = con.createStatement();
	prstemt.setInt(1,-1);
	prstemt.setString(2, title);
	prstemt.setString(3, cont);
	prstemt.executeUpdate();
	ResultSet rs= prstemt.getGeneratedKeys();
	rs.next();
	int key = rs.getInt(1);
	System.out.println(key);
	rs.close();
	stem.executeUpdate("update article set rootid = "+key+" where id = "+key);
	con.commit();
	con.setAutoCommit(true);
	stem.close();
	prstemt.close();
	con.close();
	response.sendRedirect("showflat.jsp");
	}
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>reply</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
   <form action="post.jsp" method="post">
   		<input type="hidden" name="action" value="post">
    <table border="1">
    	<tr>
    		<td>
    		<input type="text" name="title" size="60">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<textarea cols="65" rows="12" name="cont"></textarea>
    		 </td>
    	</tr>
    	<tr>
    		<td>
    			<input type="submit" value="Ìá½»">
    		 </td>
    	</tr>
    </table>
   </form>
  </body>
</html>
