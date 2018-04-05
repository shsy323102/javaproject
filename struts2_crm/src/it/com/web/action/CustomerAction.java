package it.com.web.action;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import it.com.domain.Customer;
import it.com.service.CustomerService;
import it.com.service.UserService;
import it.com.service.impl.CustomerServiceImp;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	private Customer c = new Customer();
	public String list() throws Exception {
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		CustomerService cts = (CustomerService) ac.getBean("custmerService");
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(cust_name)){
			dc.add(Restrictions.like("cust_name","%"+cust_name+"%"));
		}
		List<Customer> list = cts.ListAll(dc);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	public String add(){
		ServletContext sc = ServletActionContext.getServletContext();
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		CustomerService cts = (CustomerService) ac.getBean("custmerService");
		cts.save(c);
		return "toList";
	}
	@Override
	public Customer getModel() {
		return c;
	}
}
