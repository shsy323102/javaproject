package it.com.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import it.com.domain.Customer;
import it.com.service.CustomerService;
import it.com.utils.PageBean;
@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService customerService;
	private Integer currentPage;
	private Integer pageSize;
	private File photo;
	
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String list() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
		}
		PageBean pb=customerService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean",pb);
		return "list";
	}
	public String add()throws Exception{
		if(photo!=null){
		photo.renameTo(new File("D:/file/"+customer.getCust_name()+".jpg"));
		}
		customerService.save(customer);
		return "toList";
	}
	public String toEdit()throws Exception{
		Customer c = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("customer",c);
		return "toEdit";
	}
	public String indutryCount()throws Exception{
		List<Object[]> list = customerService.indutryCount();
		ActionContext.getContext().put("list",list);
		return "indutryCount";
	}
	
}
