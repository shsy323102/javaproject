package com.web;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickServerlet implements Servlet{

	public void destroy() {
		System.out.println("destory...");
	}


	public ServletConfig getServletConfig() {
		
		return null;
	}


	public String getServletInfo() {
	
		return null;
	}


	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init...");
		
	}


	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("helloservlet");
	}

}
