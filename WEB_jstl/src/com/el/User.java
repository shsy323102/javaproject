package com.el;

public class User {
	private int id;
	private String name;
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
	public static User getUser(int id,String name){
		User u = new User();
		u.setId(id);
		u.setName(name);
		return u;
	}
}
