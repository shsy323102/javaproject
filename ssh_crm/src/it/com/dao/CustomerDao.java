package it.com.dao;
import java.util.List;

import it.com.domain.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	List<Object[]> indutryCount();
}
