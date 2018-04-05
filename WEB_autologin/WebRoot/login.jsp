<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<title>用户登陆</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script>
	$(function(){
		$("#user").blur(function(){
			var username = $(this).val();
		$.ajax({
   			type: "POST",
  			url: "checkusername.jsp",
  			data:"username="+username,
  			success: function(msg){
    			 $("#span1").text(msg);
  				}	
			});
		});
	});
</script>
</head>
<body>
	<form action="checklogin.jsp" method="post">
		<table align="center" border="2">
			<tr>
				<td colspan="2" align="center">用户登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="user" size="15" ><span id="span1"></span>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type=password name="password" size="15" maxlength="12">
				</td>
			</tr>
		</table>
		<div align="center">
			<input type="submit" value="登陆">
			<input type="reset"  value="重置">
		</div>
	</form>
</body>
</html>
