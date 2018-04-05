package it.com.domes;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Dome9 extends ActionSupport{
	@Override
	public String execute() throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("tom");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		ActionContext.getContext().put("list",list);
		return SUCCESS;
	}
	

}
