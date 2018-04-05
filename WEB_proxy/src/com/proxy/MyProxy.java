package com.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
 	public void test(){
		TargetInterface proxy = (TargetInterface)Proxy.newProxyInstance(
				Element.class.getClassLoader(),
				new Class[]{TargetInterface.class},
				new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("Myproxy start");
				Object o = method.invoke(new Element(),args);
				System.out.println("Myproxy end");
				return o;
			}
		});
		proxy.run();
		System.out.println(proxy.run2("abc"));
 	}
 	
}
