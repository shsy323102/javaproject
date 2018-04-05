<%@page import="com.zhj.shopping.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String action = request.getParameter("action");
	if (action != null && action.equals("login")) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(User.checkUsername(username)==true)
		{
			if(User.checkPassword(username, password)==true)
			{
				User u = User.getUser(username);
				session.setAttribute("User", u);
				response.sendRedirect("selfservice.jsp");
			}
			else
			{
				out.println("password not correct!");
				return;
			}
		}
		else 
		{
				out.println("username not exist!");
				return;
		}
		
	}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>

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
	<form name="form" action="login.jsp" method="post">
		<input type="hidden" name="action" value="login" />
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">用户登陆</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type=text name="username" size="30" maxlength="10">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type=password name="password" size="15"
					maxlength="12"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>
