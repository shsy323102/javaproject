package it.com.web.action;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import it.com.domain.User;
import it.com.service.UserService;
import it.com.service.impl.UserServiceImp;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	public String login() throws Exception {
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		UserService us = (UserService) ac.getBean("userService");
		User u= us.login(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toindex";
	}
	@Override
	public User getModel() {
		return user;
	}
	
}
