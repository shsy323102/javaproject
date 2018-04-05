package it.com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.Customer;

public interface CustomerService {
	 void save(Customer c);

	List<Customer> ListAll();

	List<Customer> ListAll(DetachedCriteria dc);


}
