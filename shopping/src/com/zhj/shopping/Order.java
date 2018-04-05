package com.zhj.shopping;

import java.sql.Timestamp;

public class Order {
	
	private int id;
	private String addr;
	private Timestamp odate;
	private int status;
	private User user;
	private CaryList carylist;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Timestamp getOdate() {
		return odate;
	}
	public void setOdate(Timestamp odate) {
		this.odate = odate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CaryList getCarylist() {
		return carylist;
	}
	public void setCarylist(CaryList carylist) {
		this.carylist = carylist;
	}

}
