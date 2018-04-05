<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@	page import="com.el.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%	
	request.setAttribute("count", 10);
	User u = User.getUser(1,"zhangsan");
	session.setAttribute("User", u); 
	List<User> users = new ArrayList<User>();
	Map<String,User> map = new HashMap<String,User>();
	for(int i=0;i<5;i++){
		User user = User.getUser(i, "name"+i);
		users.add(user);
		map.put("user"+i, user);
		}
	session.setAttribute("Users", users);
	session.setAttribute("map", map);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <div>${pageContext.request.contextPath }</div>
 <c:if test="${empty User}">
 	登陆
 </c:if>
  <c:if test="${!empty User}">
 	已登陆
 </c:if>
 <h1>for循环</h1>
 <c:forEach begin="0" end="4" var="i">
 	${i } <br/>
 </c:forEach>
 <h1>users</h1>
 <c:forEach items="${Users }" var="user">
 id:${user.id } ${user.name } <br/>
 </c:forEach>
 <h1>map遍历</h1>
 <c:forEach items="${map }" var="entry">
 ${entry.key } ${entry.value.id }-->${entry.value.name }<br/> 
 </c:forEach>
  <br>
  </body>
</html>
