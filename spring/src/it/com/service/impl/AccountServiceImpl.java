package it.com.service.impl;

import it.com.dao.AccountDao;
import it.com.dao.impl.AccountDaoImp;
import it.com.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDaoImp accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(Integer from, Integer to, Double money) {
		accountDao.decreaseMoney(from, money);
		accountDao.increaseMoney(to, money);
	}

}
