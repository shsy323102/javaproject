package it.com.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import it.com.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;
	
	public BaseDaoImpl() {
		ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) pt.getActualTypeArguments()[0];
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
	public void delete(Serializable id) {
		T t = getById(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>)getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return null;
		
	}

	@Override
	public List<T> getList(DetachedCriteria dc, int start, Integer pageSize) {
		List<T> list= (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
		
	}

}
