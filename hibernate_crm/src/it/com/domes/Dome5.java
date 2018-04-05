package it.com.domes;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import it.com.domain.Customer;
import it.com.utils.HibernateUtils;

public class Dome5 {
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql ="from Customer c inner join c.Linkmans";
		Query query = session.createQuery(hql);
		List<Object[]> list =query.list();
		for(Object[] o :list){
			System.out.println(Arrays.toString(o));
		}
	
		tx.commit();
		session.close();
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql ="from Customer c left join c.Linkmans";
		Query query = session.createQuery(hql);
		List<Object[]> list =query.list();
		for(Object[] o :list){
			System.out.println(Arrays.toString(o));
		}
	
		tx.commit();
		session.close();
	}
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql ="from Customer c right join fetch c.Linkmans";
		Query query = session.createQuery(hql);
		List<Customer> list =query.list();
		System.out.println(list);
		tx.commit();
		session.close();
	}

}
