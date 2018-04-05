package com.zhj.shopping;

import java.util.List;
import com.zhj.shopping.dao.*;
public class ProductMgr {
	 private static ProductMgr  m;
	 static {
		 if(m==null){
			 m = new ProductMgr();
			 m.setDao(new ProductMysqlDAO());
		 }
	 }
	 private ProductMgr(){};
	 public static ProductMgr getinstance(){
		 return m;
	 }
		ProductDAO dao = null;
	public ProductDAO getDao() {
			return dao;
		}
		public void setDao(ProductDAO dao) {
			this.dao = dao;
		}
		public List<Product> getproducts(){
			return dao.getproducts();
		}
	public List<Product> getproducts(int pageno,int pagesize){
		return dao.getproducts(pageno, pagesize);
	}
	public List<Product> findproducts(int id,int pageno,int pagesize){
		return dao.findproducts(id, pageno, pagesize);
	}
	public List<Product> findproducts(int id){
		return dao.findproducts(id);
	}
	public boolean deleteProductById(int id){
		return dao.deleteProductById(id);
	}
	public boolean updateProduct(Product p){
		return dao.updateProduct(p);	
	}
	public boolean addProduct(Product p){
		return dao.addProduct(p);
	}
	public Product productLoadById(int id){
		return dao.productLoadById(id);
	}
}
