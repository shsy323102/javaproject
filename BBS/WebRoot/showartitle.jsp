<%@ page language="java"  import="java.util.*" pageEncoding="GBK" %>
<%@ page import="java.sql.*" %>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
	Statement stem=con.createStatement();
	ResultSet rs=stem.executeQuery("select * from article where id ="+id);
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showartitle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <%
    if(rs.next())
   {
   
    
     %>
     <table border="1">
     <tr>
    	 <td>ID</td>
    	 <td><%=rs.getInt("id") %></td>
     </tr>
      <tr>
    	 <td>Title</td>
    	 <td><%=rs.getString("title") %></td>
     </tr>
      <tr>
    	 <td>Content</td>
    	 <td><%=rs.getString("cont") %></td>
     </tr>
     </table>
      <a href="reply.jsp?id=<%=rs.getInt("id")%>&rootid=<%= rs.getInt("rootid")%>"> »Ø¸´
      </a>
  </body>
      <%
      rs.close();
      stem.close();
      con.close();
   }
      %>
</html>
