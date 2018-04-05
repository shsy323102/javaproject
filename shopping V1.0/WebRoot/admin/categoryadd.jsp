<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%
	request.setCharacterEncoding("gb2312");
	int pid = 0;
	String strpid = request.getParameter("pid");
	if(strpid!=null && !strpid.trim().equals(""))
	{
		pid=Integer.parseInt(strpid);
	}	 
 	String action = request.getParameter("action");
 	if(action!=null && action.equals("add"))
 	{
 		String name= request.getParameter("name");
 		String descr=request.getParameter("descr");
 		if(pid==0)
 		{
 			Category.addTopCategory(name, descr);
 		}
 		 else
 		{
 			Category parent= Category.loadbyId(pid);
 			Category child = new Category();
 			child.setName(name);
 			child.setDescr(descr);
 			parent.addchild(child);
 		}
 %>		
 	<center> category already add!</center>
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
<title>添加新类别</title>
<script language=javaScript src="script/regcheckdata.js"></script>
</head>
<body>
	<form name="form" action="categoryadd.jsp" method="post">
		<input type="hidden" name="action" value="add" />
		<input type="hidden"  name="pid"  value="<%=pid%>">
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">添加根类别</td>
			</tr>
			<tr>
				<td>类别名称：</td>
				<td><input type=text name="name" size="30" maxlength="10">
				</td>
			</tr>
			<tr>
			<td>类别描述：</td>
			<td><textarea rows="12" cols="40" name="descr"> </textarea> </td>
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
