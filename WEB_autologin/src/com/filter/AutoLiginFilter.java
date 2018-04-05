package com.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.web.User;

public class AutoLiginFilter implements Filter{


	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse rsp = (HttpServletResponse) arg1;
		HttpSession session = req.getSession(); 
		String cookie_username=null;
		String cookie_password=null;
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("cookie_username".equals(cookie.getName())){
					cookie_username=cookie.getValue();
					cookie_username=URLDecoder.decode(cookie_username, "UTF-8");
				}
				if("cookie_password".equals(cookie.getName())){
					cookie_password=cookie.getValue();
				}
			}
		}
		if(cookie_username!=null&&cookie_password!=null){
			User u = new User();
			u.setUsername(cookie_username);
			u.setPassword(cookie_password);
			System.out.println(cookie_username);
			System.out.println(cookie_password);
			session.setAttribute("User", u);
		}
		arg2.doFilter(arg0, arg1);
	}

}
