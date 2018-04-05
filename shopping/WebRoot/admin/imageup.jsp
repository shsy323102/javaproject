<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	int pageno = 1;
	int pagesize = 3;
	String strpageno = request.getParameter("pageno");
   	if(strpageno!=null){
   	 pageno = Integer.parseInt(strpageno);
   	 if(pageno<1)
   	 pageno=1;
   }
	List<Product> products = ProductMgr.getinstance().getproducts(pageno,pagesize); 
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
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
    		<td>ID</td>
    		<td>name</td>
    		<td>descr</td>
    		<td>上传图片</td>
    	</tr>
    <%
    	for(Iterator<Product> it = products.iterator();it.hasNext();)
    	{
    	Product p = it.next();
    	 %>
    	 <tr>
    		<td><%=p.getId() %></td>
    		<td><%=p.getName() %></td>
    		<td><%=p.getDescr() %></td>
    		 <td> <a href="admin/ProductUpload.jsp?id=<%=p.getId() %>">图片上传</a></td>
    	</tr>
     <%
     }
    %>
 
   
    </table>
       <br>
  <center>
   <a href="admin/productlist.jsp?pageno=<%=pageno-1%>">上一页</a> 
   &nbsp;&nbsp;
   <a href="admin/productlist.jsp?pageno=<%=pageno+1%>">下一页</a> 
  </center>
  </body>
</html>
