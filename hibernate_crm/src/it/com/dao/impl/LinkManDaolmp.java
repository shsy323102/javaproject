package it.com.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import it.com.dao.LinkManDao;
import it.com.domain.LinkMan;
import it.com.utils.HibernateUtils;

public class LinkManDaolmp implements LinkManDao{

	public void save(LinkMan lm) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}


	@Override
	public List<LinkMan> ListAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		List<LinkMan> list =c.list();
		return list;
	}

}
