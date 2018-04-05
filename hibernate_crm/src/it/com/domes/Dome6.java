package it.com.domes;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import it.com.domain.Customer;
import it.com.domain.Role;
import it.com.domain.User;
import it.com.utils.HibernateUtils;

public class Dome6 {
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		User u1 = new User();
		u1.setUser_name("aaa");
		User u2 = new User();
		u2.setUser_name("bbb");
		Role r1 = new Role();
		r1.setRole_name("clear");
		Role r2 = new Role();
		r2.setRole_name("manage");
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql ="from Customer order by cust_id desc";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql ="select count(*) from Customer";
		Query query = session.createQuery(hql);
		Number number = (Number) query.uniqueResult();
		System.out.println(number);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql ="select cust_name from Customer";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}
}
