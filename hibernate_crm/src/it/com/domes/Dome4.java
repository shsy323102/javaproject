package it.com.domes;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import it.com.domain.Customer;
import it.com.domain.LinkMan;
import it.com.utils.HibernateUtils;

public class Dome4 {
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("hpu");
		LinkMan man1 = new LinkMan();
		man1.setLkm_name("tom");
		LinkMan man2 = new LinkMan();
		man2.setLkm_name("jany");
		c.getLinkmans().add(man1);
		c.getLinkmans().add(man2);
		man1.setCustomer(c);
		man2.setCustomer(c);
		session.save(c);
		session.save(man1);
		session.save(man2);
		
		tx.commit();
		session.close();
	}
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 2L);
		LinkMan lk = session.get(LinkMan.class,2);
		c.getLinkmans().remove(lk);
		lk.setCustomer(null);
		
		tx.commit();
		session.close();
	}
	@Test
	//cascade="all"
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.load(Customer.class, 3L);
		session.delete(c);
		
		tx.commit();
		session.close();
	}
}
