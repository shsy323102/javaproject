<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@	page import="com.zhj.shopping.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	User u = (User)session.getAttribute("User");
	if(u==null){
		out.print("��û�е�¼!!!");
		out.print("<a href='login.jsp'>��½</a>");
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
  <center>��һ������<%=caries.size()%>����Ʒ:</center>
    <table border="2" align="center">
    	<tr>
    		<td>ID</td>
    		<td>name</td>
    		<td>�۸�<%=(u==null ? "(�г���)":"(��Ա��)")%></td>
    		<td>����</td>
    	
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
		�ܼ�<%=Math.round(carylist.getotalprice()*100)/100.0 %>Ԫ<br>
   		
   <form action="order.jsp" method="post">
   	�ͻ���Ϣ��<br>
   	<% 
   		if(u!=null){
   			out.print("userid:"+u.getId()+"&nbsp&nbspname:"+u.getUsername()+"<br>");
   		 }
   	 %>
   		<textarea rows="2" cols="80"><%=(u==null ?"":u.getAddr())%></textarea>
   		<br>
   		<input type="submit" value="ȷ���µ�">
   </form>
    </center>  
  </body>
  </head>
</html>
