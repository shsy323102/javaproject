package it.com.service;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.LinkMan;
import it.com.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	LinkMan getById(Long lkm_id);

}
