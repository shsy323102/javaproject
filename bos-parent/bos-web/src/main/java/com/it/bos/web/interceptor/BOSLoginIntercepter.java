package com.it.bos.web.interceptor;

import com.it.bos.domain.User;
import com.it.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BOSLoginIntercepter extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User u = BOSUtils.getLoginUser();
		if(u!=null){
			return invocation.invoke();
		}
		return "login";
	}

	
}
