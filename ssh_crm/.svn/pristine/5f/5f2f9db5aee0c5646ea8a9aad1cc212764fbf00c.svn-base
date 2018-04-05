package it.com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.dao.SaleVisitDao;
import it.com.domain.Customer;
import it.com.domain.SaleVisit;
import it.com.service.SaleVisitService;
import it.com.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao saleVisitDao;
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	@Override
	public void save(SaleVisit saleVisit) {
		if(saleVisit.getVisit_id()==null||saleVisit.getVisit_id().equals("")){
			saleVisitDao.save(saleVisit);
		}
		else {
			update(saleVisit);
		}

	}
	
	public void update(SaleVisit saleVisit) {
		saleVisitDao.update(saleVisit);
	}
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		List<SaleVisit> list = saleVisitDao.getList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
		
	}
	@Override
	public SaleVisit getById(String visit_id) {
		return saleVisitDao.getById(visit_id);
	}


}
