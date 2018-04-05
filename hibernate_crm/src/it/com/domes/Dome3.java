package it.com.domes;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import it.com.domain.Customer;
import it.com.utils.HibernateUtils;

public class Dome3 {
	
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String sql ="select * from cst_customer";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String sql ="select * from cst_customer where cust_id =?";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);
		query.setParameter(0, 1l);
		List<Customer> list = query.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
}
