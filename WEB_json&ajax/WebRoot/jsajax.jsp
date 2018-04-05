<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>用户注册</title>
<script language=javaScript src="script/regcheckdata.js"></script>
<script>
	function checkdata(){
		if(window.XMLHttpRequest()){
			req = new XMLHttpRequest();
		}	else if (window.ActiveXObject){
		   req = new  ActiveXObject();
         
		}
	 req.open("GET","check.jsp",true);
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
	<form name="form" action="rejister.jsp" method="post">
		<table align="center" border="2">
			<tr>
				<td colspan="2" align="center">用户注册</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type=text name="username" id="userid" size="15" maxlength="12" onblur="checkdata()">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type=password name="password" size="15" maxlength="12">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
