package com.web;

import java.lang.reflect.Method;

public class MyTestParster {
	public static void main(String[] args) {
		Class clazz = MyDome.class;
		Method[] methods = clazz.getMethods();
		if(methods!=null){
			for(Method method:methods){
				if(method.isAnnotationPresent(MyTest.class)){
					try {
						method.invoke(clazz.newInstance(),null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				}
			}
		}
	}
}
