<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
		String cookie_username=null;
		String cookie_password=null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("cookie_username".equals(cookie.getName())){
					cookie_username=cookie.getValue();
				}
				if("cookie_password".equals(cookie.getName())){
					cookie_password=cookie.getValue();
				}
			}
		}
		
			System.out.println(cookie_username);
			System.out.println(cookie_password);
			
%>