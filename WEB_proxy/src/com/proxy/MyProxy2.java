package com.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import com.proxy.Element;
import org.junit.Test;

public class MyProxy2 {
	Element target = new Element();
	@Test
	public void test2(){
 		TargetInterface proxy = (TargetInterface)Proxy.newProxyInstance(
 				target.getClass().getClassLoader(),
 				target.getClass().getInterfaces(),
 				new InvocationHandler() {

					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						Object o = method.invoke(target, args);
						return o;
					}
 				});
 				proxy.run();
 				System.out.println(proxy.run2("eee"));
 		 	}
}
