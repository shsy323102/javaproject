package it.com.web.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import it.com.domain.User;
import it.com.service.UserService;
import it.com.service.impl.UserServiceImp;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService us = new UserServiceImp();
	public String login() throws Exception {
		User u= us.login(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toindex";
	}
	@Override
	public User getModel() {
		return user;
	}
	
}
