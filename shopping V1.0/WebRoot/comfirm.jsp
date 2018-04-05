<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@	page import="com.zhj.shopping.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	User u = (User)session.getAttribute("User");
	if(u==null){
		out.print("你没有登录!!!");
		out.print("<a href='login.jsp'>登陆</a>");
	}
	CaryList carylist = (CaryList)session.getAttribute("carylist");
		List<Cary> caries = new ArrayList<Cary>();
		if(carylist==null){
		out.println("carylist is empty!");
			return;
		}
		caries = carylist.getCaries();	
 %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>comfirm</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <body>
  <center>你一共买了<%=caries.size()%>件商品:</center>
    <table border="2" align="center">
    	<tr>
    		<td>ID</td>
    		<td>name</td>
    		<td>价格<%=(u==null ? "(市场价)":"(会员价)")%></td>
    		<td>数量</td>
    	
    	</tr>
    <%
    	for(Iterator<Cary> it = caries.iterator();it.hasNext();)
    	{
           Cary c = it.next();
    	 %>
    	<tr>
    		<td><%=c.getId() %></td>
    		<td><%=c.getName() %></td>
    		<td><%=c.getPrice()%></td>
    		<td><%=c.getId()%></td>
    	</tr>
     <%
     }
    %>
    </table>
 		<center>
		总计<%=Math.round(carylist.getotalprice()*100)/100.0 %>元<br>
   		
   <form action="order.jsp" method="post">
   	送货信息：<br>
   	<% 
   		if(u!=null){
   			out.print("userid:"+u.getId()+"&nbsp&nbspname:"+u.getUsername()+"<br>");
   		 }
   	 %>
   		<textarea rows="2" cols="80"><%=(u==null ?"":u.getAddr())%></textarea>
   		<br>
   		<input type="submit" value="确认下单">
   </form>
    </center>  
  </body>
  </head>
</html>
