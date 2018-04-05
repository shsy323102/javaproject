package com.it.bos.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.it.bos.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType p = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = p.getActualTypeArguments();
		clazz=(Class<T>) actualTypeArguments[0];
	}

	@Resource
	public void mySetSF(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public T findById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		String hql = "from "+clazz.getSimpleName();
		return (List<T>) getHibernateTemplate().find(hql);
	}

	@Override
	public void executeUpdate(String quaryName, Object... objects) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(quaryName);
		int i = 0;
		for (Object object : objects) {
			query.setParameter(i++, object);
		}
		query.executeUpdate();
	}

	
}
