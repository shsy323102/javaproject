package it.com.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import it.com.dao.CustomerDao;
import it.com.domain.Customer;
import it.com.utils.HibernateUtils;

public class CustomerDaoImp implements CustomerDao {
	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(c);	
	}

	@Override
	public List<Customer> ListAll() {
		Session session = HibernateUtils.getCurrentSession();
		String sql ="select * from cst_customer";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		return list;
	}
	@Override
	public Customer getById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Customer c = session.get(Customer.class, cust_id);
		return c;
	}

	@Override
	public List<Customer> ListAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		List<Customer> list =c.list();
		return list;
	}

}
