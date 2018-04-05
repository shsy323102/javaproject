package it.com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import it.com.domain.User;

public class Dome1 {
	@Test
	public void fun(){
		Configuration cf = new Configuration().configure();
		SessionFactory sf = cf.buildSessionFactory();
		Session session = sf.openSession();
		 Transaction tx = session.beginTransaction();
		 tx.begin();
		 
		 User u = new User();
		 u.setUser_name("wangwang");
		 session.save(u);
		 
		 tx.commit();
		 session.close();
		 sf.close();
		
	}
}
