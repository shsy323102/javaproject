<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.zhj.shopping.*" %>
<%
 	request.setCharacterEncoding("gb2312");
 	String action = request.getParameter("action");
 	if(action!=null && action.equals("rejister"))
 	{
 		String username= request.getParameter("username");
 		String password= request.getParameter("password");
 		String phone= request.getParameter("phone");
 		String addr= request.getParameter("addr");
 		User u = new User();
 		u.setUsername(username);
 		u.setPassword(password);
 		u.setAddr(addr);
 		u.setPhone(phone);
 		u.setRdate(new java.sql.Date(System.currentTimeMillis()));
 		u.save();
 %>
 	<center> rejisterOK!</center>
 	 <%
 	return;
 	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>�û�ע��</title>
<script language=javaScript src="script/regcheckdata.js"></script>
<script>
	var req;
	window.onload=function checkid(){
		
		var id = Document.getElementById("userid");
		var url ="valite.jsp?id="+escape(id.value);
		if(window.XMLHttpRequest()){
			req = new XMLHttpRequest();
		}	else if (window.ActiveXObject){
		   req = new  ActiveXObject();
         
		}
	 req.open("GET",url,true);
	 req.onreadystatechange = callback;
	 req.send(null);
	}
	function callback(){
	  if(req.readyState==4){
	  	alert(req.status);
	  	}
	  }
</script>
</head>
<body>
	<form name="form" action="rejister.jsp" method="post"
		onSubmit="return checkdata()">
		<input type="hidden" name="action" value="rejister" />
		<table width="750" align="center" border="2">
			<tr>
				<td colspan="2" align="center">�û�ע��</td>
			</tr>
			<tr>
				<td>�û�����</td>
				<td><input type=text name="username" id="userid" size="30" maxlength="10" onblur="checkid()">
				</td>
			</tr>
			<tr>
				<td>���룺</td>
				<td><input type=password name="password" size="15" maxlength="12">
				</td>
			</tr>
			<tr>
				<td>����ȷ��</td>
				<td><input type=password name="password2" size="15" maxlength="12">
				</td>
			</tr>
			<tr>
				<td>�绰</td>
				<td><input type=text name="phone" size="15" maxlength="12">
				</td>
			</tr>
			<tr>
			<td>��ַ</td>
			<td><textarea rows="12" cols="80" name="addr"> </textarea> </td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="�ύ">
				 <input type="reset" value="����"></td>
			</tr>

		</table>
	</form>
</body>
</html>
