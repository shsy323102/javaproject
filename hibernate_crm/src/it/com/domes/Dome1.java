package it.com.domes;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import it.com.domain.Customer;
import it.com.utils.HibernateUtils;

public class Dome1 {
	@Test
	public void fun1(){
		Session session1 = HibernateUtils.getCurrentSession();
		Session session2 = HibernateUtils.getCurrentSession();
		System.out.println(session1==session2);
	}
	public void fun2(){
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		System.out.println(session1==session2);
	}
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer where Cust_id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 1l);
		Customer c = (Customer)query.uniqueResult();
		System.out.println(c);
		
		tx.commit();
		session.close();
	}
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer";
		Query query = session.createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(2);
		@SuppressWarnings("unchecked")
		List<Customer> customers = query.list();
		System.out.println(customers);
		tx.commit();
		session.close();
	}
}
