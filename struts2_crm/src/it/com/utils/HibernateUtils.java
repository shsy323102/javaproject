package it.com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		Configuration configuration= new Configuration().configure();
		 sf = configuration.buildSessionFactory();
	}
	public static Session openSession(){
		Session session = sf.openSession();
		return session;
	}
	public static Session getCurrentSession(){
		Session session = sf.getCurrentSession();
		return session;
	}
}
