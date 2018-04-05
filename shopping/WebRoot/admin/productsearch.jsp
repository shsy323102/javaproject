<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<Product> products = null; 
	String action = request.getParameter("action");
	String productid= request.getParameter("productid");
	int id=1;
	if(action!=null&&action.equals("search")){
		if(productid!=null){
		 id = Integer.parseInt(productid);
		 products = ProductMgr.getinstance().findproducts(id);
		}
	}
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

  		
  
  <form action="admin/productsearch.jsp" name="form" method="post">
  	<input type="hidden" name="action" value="search">
  <%
  	 if(products!=null){
   %>
    <table border="1" align="center">
    	<tr>
    		<td>ID</td>
    		<td>name</td>
    		<td>descr</td>
    		<td>市场价</td>
    		<td>会员价</td>
    		<td>date</td>
    		<td>类别id</td>
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
    		<td><%=p.getNormalprice() %></td>
    		<td><%=p.getMemberprice() %></td>
    		<td><%=p.getPdate()%></td>
    		<td><%=p.getCategoryid()%></td>
    	</tr>
     <%
     }
   %>
 
    </table>
   <%
   } 
 %> 	
  
    <table border="0" align="center">
   		 <tr>
			 <td><input type="text" name="productid" ></td>
			<td><input type="submit" value="搜索"></td>
		</tr>
	</table>
 </form>

  </body>
</html>
