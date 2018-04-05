package it.com.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import it.com.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		if(u!=null){
			return invocation.invoke();
		}else {
			return "tologin";
		}
		
	}

}
