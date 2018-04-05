package com.zhj.shopping.dao;

import java.util.List;
import com.zhj.shopping.Product;

public interface ProductDAO {
	
	public List<Product> getproducts(int pageno,int pagesize);
	
	public List<Product> getproducts();
	
	public List<Product> findproducts(int id);
	
	public List<Product> findproducts(int id,int pageno,int pagesize);
	
	public boolean deleteProductById(int id);
	
	public boolean updateProduct(Product p);
	
	public boolean addProduct(Product p);

	public Product productLoadById(int id);
}
