<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" import="com.zhj.shopping.dao.*" %>
<%@ include file="sessioncheck.jsp"%>
<%
	request.setCharacterEncoding("gb2312");
 	String action = request.getParameter("action");
 	String strcategoryid= request.getParameter("categoryid");
 	int categoryid = 0;
 	if(strcategoryid!=null&&!strcategoryid.trim().equals("")){
 		categoryid = Integer.parseInt(strcategoryid);
 	}
 	if(action!=null && action.equals("addproduct"))
 	{
 		String name= request.getParameter("name");
 		String descr=request.getParameter("descr");
 		String normalprice = request.getParameter("normalprice");
 		String memberprice = request.getParameter("memberprice");
 		Product p = new Product();
 		p.setId(-1);
 		p.setName(name);
 		p.setDescr(descr);
 		p.setNormalprice(Double.parseDouble(normalprice));
 		p.setMemberprice(Double.parseDouble(memberprice));
 		p.setPdate(new java.sql.Timestamp(System.currentTimeMillis()));
 	    p.setCategoryid(categoryid);
 	    ProductMgr.getinstance().addProduct(p);	
 %>		
  	<center> product already add! <a href="productlist.jsp">返回列表</a></center>
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
	<form name="form" action="productadd.jsp" method="post" >
		<input type="hidden" name="action" value="addproduct" />
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">添加新产品</td>
			</tr>
			<tr>
				<td>产品名称：</td>
				<td><input type=text name="name" size="30" maxlength="10">
				</td>
			</tr>
			
			<tr>
			<td>产品 描述：</td>
			<td><textarea rows="1" cols="50" name="descr"> </textarea> </td>
			</tr>
				<tr>
				<td>市场价：</td>
				<td><input type=text name="normalprice" size="30" maxlength="10">
				</td>
			</tr>
				<tr>
				<td>会员价 ：</td>
				<td><input type=text name="memberprice" size="30" maxlength="10">
				</td>
			</tr>
				<tr>
				<td>类别id：</td>
				<td>
				 <select name="categoryid">
				 <option value="0">所有类别</option>
<%
		List<Category> list = Category.getCategories();
		int index = 1;
		for(Iterator<Category> it = list.iterator();it.hasNext();){
			Category c = it.next();
			String str ="";
			for(int i=1;i<c.getGrade();i++){
			 str+="----";
			 }
 %>
		<option value="<%=c.getId()%>" <%=c.getId()==categoryid ?"selected":""%>><%=str+c.getName()%></option>
 <%
 		index++;
 		}
  %>
				 </select>
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
