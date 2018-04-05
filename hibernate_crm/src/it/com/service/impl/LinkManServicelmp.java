package it.com.service.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import it.com.dao.CustomerDao;
import it.com.dao.LinkManDao;
import it.com.dao.impl.CustomerDaoImp;
import it.com.dao.impl.LinkManDaolmp;
import it.com.domain.Customer;
import it.com.domain.LinkMan;
import it.com.service.LinkManService;
import it.com.utils.HibernateUtils;

public class LinkManServicelmp implements LinkManService {
	private CustomerDao csd= new CustomerDaoImp();
	private LinkManDao lsd = new LinkManDaolmp(); 
	
	@Override	
	public void save(LinkMan lm) {
		Transaction tx = HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			Customer c = csd.getById(lm.getCust_id());
			lm.setCustomer(c);
			lsd.save(lm);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<LinkMan> ListAll(DetachedCriteria dc) {
		List<LinkMan> list = null;
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			 list = lsd.ListAll(dc);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}

}
