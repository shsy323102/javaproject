package cn.itcast.crm.service.impl;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao  customerDao;
	
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id);
	}

}
