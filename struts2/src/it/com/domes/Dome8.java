package it.com.domes;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Dome8 extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("before");
		invocation.invoke();
		System.out.println("after");
		return "success";
		
	}

	

}
