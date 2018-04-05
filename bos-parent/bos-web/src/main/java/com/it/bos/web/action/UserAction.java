package com.it.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.it.bos.domain.User;
import com.it.bos.utils.BOSUtils;
import com.it.bos.web.action.base.BaseAction;
import com.it.bos.web.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	private String checkcode;
	@Autowired
	private UserService userService;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String login(){
		String strCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNoneBlank(strCode)&&checkcode.equals(strCode)){
			User user = userService.login(model);
			if(user!=null){
				BOSUtils.getSession().setAttribute("loginUser", user);
				return HOME;
			}else {
				this.addActionError("用户名或密码不正确");
				return LOGIN;
			}
		} else {
			this.addActionError("验证码错误");
			return LOGIN;
		}
		
	}
	public String logout(){
		BOSUtils.getSession().invalidate();
		return LOGIN;
	}
	public String editPassword() throws IOException{
		String flag="1";
		User u = BOSUtils.getLoginUser();
		try {
			userService.editPassword(u.getId(),model.getPassword());
		} catch (Exception e) {
			flag="0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html/charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(flag);;
		return NONE;
	}
}
