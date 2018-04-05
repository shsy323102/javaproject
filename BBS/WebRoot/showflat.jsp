<%@ page import="com.mysql.jdbc.Statement.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=gbk" %>

<%
   	int pagesize = 3;
   	int pageno;
   	String num=request.getParameter("pageno");
   	if(num==null||num.equals("")){
   		pageno=1;
   	}
   	else{
   	try{
   	 pageno=Integer.parseInt(num.trim());
   	 }	
   	 catch(NumberFormatException e){
   	 	pageno=1;
   	 }
   	 if(pageno<=0)
   	 pageno=1;
   	}
  
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bbs?user=root&password=root");
	Statement stem=con.createStatement();
	Statement stem2=con.createStatement();
	ResultSet rs2=stem2.executeQuery("select count(*) from article where pid = 0");
	rs2.next();
	int count = rs2.getInt(1);
	int count2 = count % pagesize == 0 ? count/pagesize : count/pagesize + 1;
	if(pageno>count2){
		pageno=count2;
	}
	int start = (pageno-1)*pagesize;
	ResultSet rs=stem.executeQuery("select * from article where pid = 0 limit "+start+","+pagesize);
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Article Tree</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body>
  <a href = "post.jsp">发表新帖</a>
  <table border="1">
 <%	while(rs.next())
	{	
%>
	<tr>
		<td>
		 <%= rs.getString("title") %>
		</td>
	</tr>
<%  }	
	rs.close(); 
	stem.close();
	con.close();	
 %>
 </table>
   共<%=count2 %>页 第 <%=pageno %>页
   <a href="showflat.jsp?pageno=<%=pageno-1%>">上一页 </a>&nbsp;
    <a href="showflat.jsp?pageno=<%= pageno+1%>"> 下一页</a> 
<form action="showflat.jsp" name="form1">
 <select name="pageno" onchange="document.form1.submit()">
 <% for(int i=1;i<=count2;i++){
  %>
  	<option value=<%=i%> <%=(pageno==i)?"selected":""%>> 第 <%=i%> 页
  <%
   }
   %>
</option>
 </select>
</form>
<form name="form2" action="showflat.jsp">
	<input type = text size = 4 name ="pageno" value=<%=pageno%>></input>
	<input type= "submit" value = "go"></input>
</form>
 </body>
</html>
