package it.com.service;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.Customer;
import it.com.domain.SaleVisit;
import it.com.utils.PageBean;

public interface SaleVisitService {

	void save(SaleVisit saleVisit);
	
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	SaleVisit getById(String visit_id);


}
