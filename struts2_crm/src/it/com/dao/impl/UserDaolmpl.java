package it.com.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import it.com.dao.UserDao;
import it.com.domain.User;
import it.com.utils.HibernateUtils;

public class UserDaolmpl implements UserDao {

	@Override
	public User getByUserCode(String user_code) {
		Session session = HibernateUtils.getCurrentSession();
		String hql="from User where user_code=?";
		Query query = session.createQuery(hql);
		query.setParameter(0,user_code);
		User u = (User) query.uniqueResult();
		return u;
	}

}
