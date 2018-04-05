package it.com.dao;

import java.util.List;

import it.com.bean.UserName;

public interface UserNameDao {
	
	public void save(UserName u);
	
	public void delete(Integer id);
	
	public void update(UserName u);
	
	public UserName getById(Integer id);
	
	public int getCount();
	
	public List<UserName> getAll();
}
