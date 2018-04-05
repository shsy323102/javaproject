<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<Category> categories = Category.getCategories();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>get categories</title>
    
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
    		<td>id</td>
    		<td>pid</td>
    		<td>name</td>
    		<td>grade</td>
    	</tr>
    <%
    	for(Iterator<Category> it = categories.iterator();it.hasNext();)
    	{
    	Category c = it.next();
    		String str = "";
    		for(int i=1;i<c.getGrade();i++)
    		{
    		str+="----";
    		}
    	 %>
    	 <tr>
    		<td><%=c.getId() %></td>
    		<td><%=c.getPid() %></td>
    		<td><%=str+c.getName() %></td>
    		<td><%=c.getGrade() %></td>
    		<td><a href="admin/categoryadd.jsp?pid=<%=c.getId()%>">添加子类别</a></td>
    		<td>
    <%
    	if(c.isLeaf()){
     %>
    		<a href="admin/productadd.jsp?categoryid=<%=c.getId()%>">在该类别下添加产品</a>
    <%
    	}
     %>
    		<td>
    <%
    	if(c.isLeaf()){
     %>
    		<a href="admin/categorydelete.jsp?id=<%=c.getId()%>&pid=<%=c.getPid()%>&isleaf=<%=c.isLeaf()%>">删除</a>
     <%
    	}
     %>
    		</td>
    	</tr>
     <%
     }
    %>
    </table>
  </body>
</html>
