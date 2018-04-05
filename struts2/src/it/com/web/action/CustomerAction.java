package it.com.web.action;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import it.com.domain.Customer;
import it.com.service.CustomerService;
import it.com.service.impl.CustomerServiceImp;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	private Customer c = new Customer();
	private CustomerService cts = new CustomerServiceImp();
	public String list() throws Exception {
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
		cts.save(c);
		return "toList";
	}
	@Override
	public Customer getModel() {
		return c;
	}
}
