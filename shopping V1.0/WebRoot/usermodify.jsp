<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%@ include file="sessioncheck.jsp" %>
<%
 	request.setCharacterEncoding("gb2312");
 	String action = request.getParameter("action");
 	if(action!=null && action.equals("modify"))
 	{
 		String username= request.getParameter("username");
 		String phone= request.getParameter("phone");
 		String addr= request.getParameter("addr");
 		u.setUsername(username);
 		u.setAddr(addr);
 		u.setPhone(phone);
 		u.upDate();
	%>
 	<center> already update!</center>
 	 <%
 	return;
 	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>用户修改</title>
<script language=javaScript src="script/regcheckdata.js"></script>
</head>
<body>
	<form name="form" action="usermodify.jsp" method="post">
		<input type="hidden" name="action" value="modify" />
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">用户修改</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type=text name="username" value="<%=u.getUsername()%>" size="30" maxlength="10" >
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type=text name="phone" value="<%=u.getPhone()%>" size="15" maxlength="12">
				</td>
			</tr>
			<tr>
			<td>地址</td>
			<td><textarea rows="12" cols="80" name="addr"><%=u.getAddr()%></textarea> </td>
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
