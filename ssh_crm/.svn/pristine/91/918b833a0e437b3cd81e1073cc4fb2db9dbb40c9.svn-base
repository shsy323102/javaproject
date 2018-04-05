package it.com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.Customer;
import it.com.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void save(Customer customer);
	
	Customer getById(Long cust_id);
	
	 List<Object[]> indutryCount();

}
