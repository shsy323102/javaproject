package it.com.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import it.com.dao.AccountDao;

public class AccountDaoImp extends JdbcDaoSupport implements AccountDao{
	
	public void increaseMoney(Integer id,Double money){
		String sql ="update account set money = money + ? where id = ?";
		getJdbcTemplate().update(sql,money,id);
	}
	public void decreaseMoney(Integer id,Double money){
		String sql ="update account set money = money - ? where id = ?";
		getJdbcTemplate().update(sql,money,id);
	}
}
