package com.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListenner implements ServletContextListener{

	
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroy........");
		System.out.println("contextDestroy........");
		System.out.println("contextDestroy........");
	}

	
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialize...........");
		System.out.println("contextInitialize...........");
		System.out.println("contextInitialize...........");
	}
	

}
