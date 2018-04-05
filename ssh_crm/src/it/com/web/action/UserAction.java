package it.com.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import it.com.domain.User;
import it.com.service.UserService;
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User user = new User();
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() throws Exception{
		User u = userService.login(user);
		ActionContext.getContext().getSession().put("user",u);
		return "toHome";
	}
	public String rejist()throws Exception {
		try {
			userService.rejist(user);
		} catch (Exception e) {
			ActionContext.getContext().put("error",e.getMessage());
			return "rejist";
		}
		return "tologin";
	}
	@Override
	public User getModel() {
		return user;
	}
}
