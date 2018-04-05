package it.com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.LinkMan;

public interface LinkManService {
	void save(LinkMan lm);
	
	List<LinkMan> ListAll(DetachedCriteria dc);
}
