package com.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{

	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("bing");
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("unbing");
	}
}
