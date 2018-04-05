<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" import="com.zhj.shopping.dao.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
	request.setCharacterEncoding("gb2312");
 	String action = request.getParameter("action");
 	String productid = request.getParameter("productid");
 	 	Product	p = ProductMgr.getinstance().productLoadById(Integer.parseInt(productid));
 	if(action!=null && action.equals("modify"))
 	{	
 		String strcategoryid= request.getParameter("categoryid");
 		String name= request.getParameter("name");
 		String descr=request.getParameter("descr");
 		String normalprice = request.getParameter("normalprice");
 		String memberprice = request.getParameter("memberprice");
 		p.setName(name);
 		p.setDescr(descr);
 		p.setNormalprice(Double.parseDouble(normalprice));
 		p.setMemberprice(Double.parseDouble(memberprice));
 	    p.setCategoryid(Integer.parseInt(strcategoryid));
 	    ProductMgr.getinstance().updateProduct(p);
%>   

			<center>modify OK!</center>
 	 
 <% 
 	    return;
 	 }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加新产品</title>
</head>
<body>
	<form name="form" action="productmodify.jsp" method="post" >
		<input type="hidden" name="action" value="modify" />
		<input type="hidden" name="productid" value="<%=p.getId()%>"/>
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">修改产品</td>
			</tr>
			<tr>
				<td>产品名称：</td>
				<td><input type=text name="name" value="<%=p.getName()%>" size="30" maxlength="10">
				</td>
			</tr>
			
			<tr>
			<td>产品 描述：</td>
			<td><textarea rows="1" cols="50" name="descr"><%=p.getDescr()%></textarea></td>
			</tr>
				<tr>
				<td>市场价：</td>
				<td><input type=text name="normalprice" value="<%=p.getNormalprice()%>" size="30" maxlength="10">
				</td>
			</tr>
				<tr>
				<td>会员价 ：</td>
				<td><input type=text name="memberprice" value="<%=p.getMemberprice()%>" size="30" maxlength="10">
				</td>
			</tr>
				<tr>
				<td>类别id：</td>
				<td><input type=text name="categoryid" value="<%=p.getCategoryid()%>" size="30" maxlength="10">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交">
				 <input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
