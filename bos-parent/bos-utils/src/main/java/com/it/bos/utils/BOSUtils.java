package com.it.bos.utils;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.it.bos.domain.User;
import com.opensymphony.xwork2.ActionContext;
public class BOSUtils {
	
	public static User getLoginUser(){
		User u = (User) ActionContext.getContext().getSession().get("loginUser");
        return u;
	}
	public static HttpSession getSession(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		return session;
	}
}
