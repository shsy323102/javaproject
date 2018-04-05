package it.com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import it.com.domain.LinkMan;

public interface LinkManDao {

	void save(LinkMan lm);

	List<LinkMan> ListAll(DetachedCriteria dc);

}
