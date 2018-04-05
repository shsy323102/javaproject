package it.com.domes;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import it.com.domain.Customer;
import it.com.utils.HibernateUtils;

public class Dome2 {
	
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		
		List<Customer> customers = criteria.list();
		
		System.out.println(customers);
		tx.commit();
		session.close();
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		System.out.println(count);
		
		criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("cust_id", 1l));
		Customer c = (Customer)criteria.uniqueResult();
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.addOrder(Order.desc("cust_id"));
		List<Customer> list =criteria.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun4(){
		
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.idEq(2l));
		
		Session session = HibernateUtils.openSession();
		Criteria c = dc.getExecutableCriteria(session);
		
		List<Customer> list =c.list();
		System.out.println(list);
		
		session.close();
	}
}
