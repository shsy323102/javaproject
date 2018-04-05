到此一游<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	int rootid = Integer.parseInt(request.getParameter("rootid"));
 %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>reply</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript">
<!--	
	//javascript去空格函数 
	function LTrim(str){ //去掉字符串 的头空格
		var i;
		for(i=0;i<str.length; i++) {
			if(str.charAt(i)!=" ") break;
		}
		str = str.substring(i,str.length);
		return str;
	}
	
	function RTrim(str){
		var i;
		for(i=str.length-1;i>=0;i--){
			if(str.charAt(i)!=" "&&str.charAt(i)!=" ") break;
		}
		str = str.substring(0,i+1);
		return str;
	}
	function Trim(str){
		return LTrim(RTrim(str));
	}
	
	function check() {
		if(Trim(document.reply.title.value) == "") {
			alert("please intput the title!");
			document.reply.title.focus();
			return false;
		}
		
		if(Trim(document.reply.cont.value) == "") {
			alert("plsease input the content!");
			document.reply.cont.focus();
			return false;
		}
		
		return true;
		
	}
-->
</script>
  </head>
  
  <body>
   <form  name =reply action="replyok.jsp" method="post" onsubmit="return check()">
   		<input type="hidden" name="id" value="<%= id %>">
    	<input type="hidden" name= "rootid" value="<%= rootid %>">
    <table border="1">
    	<tr>
    		<td>
    		<input type="text" name="title" size="60">
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<textarea cols="65" rows="12" name="cont"></textarea>
    		 </td>
    	</tr>
    	<tr>
    		<td>
    			<input type="submit" value="提交">
    		 </td>
    	</tr>
    </table>
   </form>
  </body>
</html>
