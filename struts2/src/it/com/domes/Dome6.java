package it.com.domes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import it.com.domain.User;

public class Dome6 extends ActionSupport implements ModelDriven<User>{
	User u = new User();
	@Override
	public String execute() throws Exception {
		System.out.println(u);
		return SUCCESS;
	}
	
	
	@Override
	public User getModel() {
		u.setUser_id(1l);
		u.setUser_name("tom");
		return u;
	}
	
	

}
