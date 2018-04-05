package com.zhj.shopping;
import java.util.List;

import com.zhj.shopping.dao.OrderMysqlDAO;

public class OrderMgr {
	
	private	OrderMysqlDAO dao;
	public OrderMysqlDAO getDao() {
		return dao;
	}
	public void setDao(OrderMysqlDAO dao) {
		this.dao = dao;
	}
	private static OrderMgr om;
	static {
		if(om==null){
			om = new OrderMgr();
			om.setDao(new OrderMysqlDAO());
		}
	}
	private OrderMgr(){};
	public static OrderMgr getinstance(){
		return om;
	}
	public void save(Order o){
		dao.save(o);
	}
	public List<Order> getorders(){
		return dao.getorders();
	}
}
