package it.com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.Customer;

public interface CustomerDao {
	void save(Customer c);

	List<Customer> ListAll();

	Customer getById(Long cust_id);

	List<Customer> ListAll(DetachedCriteria dc);
}
