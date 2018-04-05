package it.com.dao;

public interface AccountDao  {
	
	public void increaseMoney(Integer id,Double money);
	
	public void decreaseMoney(Integer id,Double money);
}
