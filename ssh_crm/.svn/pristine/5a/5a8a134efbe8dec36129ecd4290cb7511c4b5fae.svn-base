package it.com.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.dao.LinkManDao;
import it.com.domain.LinkMan;
import it.com.service.LinkManService;
import it.com.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao; 
	public LinkManDao getLinkManDao() {
		return linkManDao;
	}
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	@Override
	public void save(LinkMan linkMan) {
		linkManDao.saveOrUpdate(linkMan);

	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = linkManDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		List<LinkMan> list = linkManDao.getList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	@Override
	public LinkMan getById(Long lkm_id) {
		
		return linkManDao.getById(lkm_id);
	}
	

}
