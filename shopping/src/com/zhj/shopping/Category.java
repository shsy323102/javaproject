package com.zhj.shopping;
import java.util.ArrayList;
import java.util.List;

public class Category {
	int id;
	int pid;
	String name;
	String descr;
	boolean leaf;
	int grade;

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void addchild(Category c){
		addChildCategory(id,c.getName(),c.getDescr() );
	}
	public static void add(Category c) {
		CategoryDAO.save(c);
	}
	public static void addChildCategory(int pid,String name,String descr)
	{
		CategoryDAO.addChildCategory(pid,name,descr);
	}
	public static void  addTopCategory(String name,String descr)
	{
		addChildCategory(0, name, descr);
	}
	public static List<Category> getCategories(){
		List<Category> List = new ArrayList<Category>();
		CategoryDAO.getCategories(List,0);
		return List;
	}
	public static Category loadbyId(int id){
		return CategoryDAO.loadbyId(id);
	}
	public static void delete(int id,int pid,boolean isleaf){
		CategoryDAO.delete(id,pid,isleaf);
	}
}
