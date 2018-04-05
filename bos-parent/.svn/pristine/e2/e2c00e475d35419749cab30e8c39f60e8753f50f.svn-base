package com.it.bos.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	void save(T t);
	
	void update(T t);
	
	void delete(T t);
	
	T findById(Serializable id);
	
	List<T> getAll();
	
	void executeUpdate(String quaryName,Object... objects);
	
}
