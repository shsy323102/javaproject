package com.web;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Custumer implements HttpSessionActivationListener,Serializable{
	
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
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("customer ´´½¨");
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		
		System.out.println("customer ¶Û»¯");
	}
}
