package it.com.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import it.com.dao.UserDao;
import it.com.domain.User;

public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao{
	@Override
	public User getByUserCode(String user_code) {
			return getHibernateTemplate().execute(new HibernateCallback<User>() {

				@Override
				public User doInHibernate(Session session) throws HibernateException {
					String hql = "from User where user_code =?";
					Query query = session.createQuery(hql);
					query.setParameter(0,user_code);
					User u = (User) query.uniqueResult();
					return u;
				}
			});
		}
	}


