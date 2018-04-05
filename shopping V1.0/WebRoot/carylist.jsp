<%@page import="com.zhj.shopping.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%		
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
    <title>cartlist</title>
    
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
  <center>你一共买了<%=caries.size()%>件商品:</center>
  <form action="carylistupdate.jsp" name="form" method="post">
    <table border="2" align="center">
    	<tr>
    		<td>ID</td>
    		<td>name</td>
    		<td>价格</td>
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
    		<td>
    		<input type="text" name="p<%=c.getId()%>" value="<%=c.getCount()%>" >
    		</td>
    	</tr>
     <%
     }
    %>
 
   
    </table>
 		<center>
		总计<%=Math.round(carylist.getotalprice()*100)/100.0 %>元<br>
			    <input type="submit" value="修改数量">
			    <input type="button" value="确认订单" onclick="document.location.href='comfirm.jsp'">
   		 </center>
  </form>    
  </body>
</html>
