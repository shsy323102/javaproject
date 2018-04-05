<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>用户注册</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	$(function(){
		$("#user").blur(function(){
			var username = $(this).val();
		$.ajax({
   			type: "POST",
  			url: "check.jsp",
  			data:"username="+username,
  			success: function(){
    			 alert("ok");
  				}	
			});
		});
	});
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
				<td><input type="text" name="username" id="user" size="15" ><span>该用户名已存在</span>
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
