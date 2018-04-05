package it.com.domes;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Dome3 extends ActionSupport{

	@Override
	public String execute() throws Exception {
		 Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		 sessionScope.put("name", "zhangsan");
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "lisi");
		return "success";
	}

}
