package com.web;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenner implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println(scae.getName());
		System.out.println(scae.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println(scae.getName());
		System.out.println(scae.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println(scae.getName());
		System.out.println(scae.getValue());
	}

}
