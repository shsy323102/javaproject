package cn.itcast.crm.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.service.CustomerService;

public class CustomerAction extends ActionSupport {
	
	private Long custId;
	
	private Customer customer;
	
	private CustomerService customerService;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}
	
	
	public String findCustomerById(){
		
		
		customer = customerService.findById(custId);
		
		System.out.println("前端传过来的客户id是："+custId);
		
		return SUCCESS;
	}
	

}
