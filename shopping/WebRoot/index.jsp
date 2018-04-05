<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ page import="com.zhj.shopping.dao.*" %>
<%
	List<Category> categories = Category.getCategories();
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
    <title>index</title>
  </head>
  <body>
  <div align="left"><a href="login.jsp">��½</a></div>
    <table border="1" align="center">
    	<tr>
    		<td>ID</td>
    		<td>name</td>
    		<td>descr</td>
    		<td>�г���</td>
    		<td>��Ա��</td>
    		<td>date</td>
    		<td>���id</td>
    		<td>��</td>
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
    		<td><a href="buy.jsp?id=<%=p.getId()%>">������</a></td>
    	</tr>
     <%
     }
    %>
    </table>
       <br>
  <center>
   <a href="index.jsp?pageno=<%=pageno-1%>">��һҳ</a> 
   &nbsp;&nbsp;
   <a href="index.jsp?pageno=<%=pageno+1%>">��һҳ</a> 
  </center>
  </body>
</html>
