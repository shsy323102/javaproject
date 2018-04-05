package com.it.bos.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.it.bos.dao.UserDao;
import com.it.bos.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUserByAccount(String username, String password) {
		String hql = "from User u where u.username =? and password =?";
		List<User> list = (List<User>) getHibernateTemplate().find(hql, username,password);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
