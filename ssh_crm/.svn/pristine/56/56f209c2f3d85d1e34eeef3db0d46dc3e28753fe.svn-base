package it.com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T>{
	void save(T t);
	
	void update(T t);
	
	void saveOrUpdate(T t);
	
	void delete(T t);
	
	void delete(Serializable id);
	
	T getById(Serializable id); 
	
	Integer getTotalCount(DetachedCriteria dc);
	
	List<T> getList(DetachedCriteria dc, int start, Integer pageSize);
}
