package com.proxy;

public class Element implements TargetInterface{

	@Override
	public void run() {
		System.out.println("Element running...");
	}
	public String run2(String str) {
		System.out.println("Element running...");
		return str;
	}
	
}
