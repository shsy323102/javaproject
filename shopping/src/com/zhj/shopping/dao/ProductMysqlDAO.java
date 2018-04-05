package com.zhj.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zhj.shopping.DB;
import com.zhj.shopping.Product;

public class ProductMysqlDAO implements ProductDAO {


	public List<Product> getproducts(int pageno, int pagesize) {
		List<Product>  list = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "select * from product limit "+(pageno-1)*pagesize+","+pagesize;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setDescr(rs.getString("descr"));
			p.setNormalprice(rs.getDouble("normalprice"));
			p.setMemberprice(rs.getDouble("memberprice"));
			p.setPdate(rs.getTimestamp("pdate"));
			p.setCategoryid(rs.getInt("categoryid"));
			list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}

	public List<Product> findproducts(int id, int pageno, int pagesize) {
		
		return null;
	}


	public boolean deleteProductById(int id) {
		Connection conn = null;
		
		try{
			conn = DB.getConn();
		DB.executeUpdate(conn,"delete from product where id ="+id);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			DB.close(conn);
		}
		return true;
	}

	
	public boolean updateProduct(Product p) {
		Connection conn = DB.getConn();
		String sql = "update product set name =?,descr =?,normalprice =?,memberprice =?,categoryid =? where id=?";
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			pstmt.setString(1,p.getName());
			pstmt.setString(2,p.getDescr());
			pstmt.setDouble(3,p.getNormalprice());
			pstmt.setDouble(4,p.getMemberprice());
			pstmt.setInt(5,p.getCategoryid());
			pstmt.setInt(6, p.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}
		return false;
	}

	
	public boolean addProduct(Product p) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = DB.getConn();
			String sql = "insert into product values (null, ?, ?, ?, ?, ?, ?)";
			pstmt = DB.prepare(conn, sql);
			pstmt.setString(1,p.getName());
			pstmt.setString(2,p.getDescr());
			pstmt.setDouble(3,p.getNormalprice());
			pstmt.setDouble(4,p.getMemberprice());
			pstmt.setTimestamp(5, p.getPdate());
			pstmt.setInt(6,p.getCategoryid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}

		return true;
	}

	@Override
	public List<Product> getproducts() {
		List<Product>  list = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "select * from product";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setDescr(rs.getString("descr"));
			p.setNormalprice(rs.getDouble("normalprice"));
			p.setMemberprice(rs.getDouble("memberprice"));
			p.setPdate(rs.getTimestamp("pdate"));
			p.setCategoryid(rs.getInt("categoryid"));
			list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}

	public List<Product> findproducts(int id) {
		List<Product>  list = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "select * from product where id="+id;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setDescr(rs.getString("descr"));
			p.setNormalprice(rs.getDouble("normalprice"));
			p.setMemberprice(rs.getDouble("memberprice"));
			p.setPdate(rs.getTimestamp("pdate"));
			p.setCategoryid(rs.getInt("categoryid"));
			list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return list;
	}

	public Product productLoadById(int id) {
		
		Connection conn = DB.getConn();
		Product p = null;
		String sql = "select * from product where id="+id;
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		try {
			if (rs.next()) {
			p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setDescr(rs.getString("descr"));
			p.setNormalprice(rs.getDouble("normalprice"));
			p.setMemberprice(rs.getDouble("memberprice"));
			p.setPdate(rs.getTimestamp("pdate"));
			p.setCategoryid(rs.getInt("categoryid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}
		return p;
	}

}
