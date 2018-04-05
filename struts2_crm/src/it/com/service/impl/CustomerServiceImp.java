package it.com.service.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import it.com.dao.CustomerDao;
import it.com.domain.Customer;
import it.com.service.CustomerService;
import it.com.utils.HibernateUtils;

public class CustomerServiceImp implements CustomerService {
	private CustomerDao customerdao;
	public CustomerDao getCustomerdao() {
		return customerdao;
	}
	public void setCustomerdao(CustomerDao customerdao) {
		this.customerdao = customerdao;
	}
	@Override
	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			customerdao.save(c);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
	}
	@Override
	public List<Customer> ListAll() {
		List<Customer> list = null;
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			 list = customerdao.ListAll();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}
	@Override
	public List<Customer> ListAll(DetachedCriteria dc) {
		List<Customer> list = null;
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			 list = customerdao.ListAll(dc);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}


}
