package com.zhj.shopping;
import java.sql.Timestamp;
public class Product {
	private int id;
	private String name;
	private String descr;
	private double normalprice;
	private double memberprice;
	private Timestamp pdate;
	private User user;
	private CaryList caries;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CaryList getCaries() {
		return caries;
	}
	public void setCaries(CaryList caries) {
		this.caries = caries;
	}
	public Timestamp getPdate() {
		return pdate;
	}
	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}
	private int categoryid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public double getNormalprice() {
		return normalprice;
	}
	public void setNormalprice(double normalprice) {
		this.normalprice = normalprice;
	}
	public double getMemberprice() {
		return memberprice;
	}
	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
}
