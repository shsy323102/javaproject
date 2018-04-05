package com.zhj.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO {
		public static void save(Category c)
		{
			Connection conn = DB.getConn();
			String sql = "insert into category values (null, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = DB.prepare(conn, sql);
			try {
				pstmt.setInt(1,c.getPid());
				pstmt.setString(2,c.getName());
				pstmt.setString(3,c.getDescr());
				pstmt.setInt(4,c.isLeaf()? 0:1);
				pstmt.setInt(5,c.getGrade());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DB.close(pstmt);
				DB.close(conn);
			}
		}
	public static void getCategories(List<Category> list, int id) {
		Connection conn = null;
		
		try {
			conn=DB.getConn();
			getCategories(conn, list, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn);
		}
	}
	private static void getCategories(Connection conn,List<Category> list, int id) {
		ResultSet rs = null;
		String sql = null; 
		try {
			sql = "select * from category where pid ="+id;
			conn = DB.getConn();
			rs = DB.getResultSet(conn, sql);
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setLeaf(rs.getInt("isleaf")==0?true:false);
				c.setPid(rs.getInt("pid"));
				c.setDescr(rs.getString("descr"));
				c.setGrade(rs.getInt("grade"));
				list.add(c);
				if(!c.isLeaf())
				{
					getCategories(list,c.getId());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
		}
	}
	public static void addChildCategory(int pid, String name, String descr) {
			Connection conn = DB.getConn();
			ResultSet rs = null;
			PreparedStatement pstmt=null;	
		try {
			int pargrade = 0;
			rs = DB.getResultSet(conn,"select * from category where id ="+pid);
			if(rs.next())
			{
				pargrade = rs.getInt("grade");
			}
			conn.setAutoCommit(false);
			 
			String sql = "insert into category values (null, ?, ?, ?, ?, ?)";
			pstmt = DB.prepare(conn, sql);
			pstmt.setInt(1,pid);
			pstmt.setString(2,name);
			pstmt.setString(3,descr);
			pstmt.setInt(4, 0);
			pstmt.setInt(5,pargrade+1);
			pstmt.executeUpdate();
			DB.executeUpdate(conn,"update category set isleaf = 1 where id ="+pid);
			conn.commit();
			conn.setAutoCommit(true);
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				DB.close(rs);
				DB.close(pstmt);
				DB.close(conn);
			}
	}
	public static Category loadbyId(int id) {
		Connection conn = null;
		ResultSet rs = null;
		String sql = null;
		Category c = null;
		try {
			sql = "select * from category where id ="+id;
			conn = DB.getConn();
			rs = DB.getResultSet(conn, sql);
			if(rs.next())
			{
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setLeaf(rs.getInt("isleaf")==0?true:false);
				c.setPid(rs.getInt("pid"));
				c.setDescr(rs.getString("descr"));
				c.setGrade(rs.getInt("grade"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(conn);
		}
		
		return c;
	}
	public static void delete(int id,int pid,boolean isleaf) {
		ResultSet rs = null;
		String sql = null;
		Connection conn=null;
		try {
			conn=DB.getConn();
			conn.setAutoCommit(false);
			if(!isleaf){
				try{
					sql = "select * from category where pid ="+id;
					rs=DB.getResultSet(conn, sql);
					while(rs.next()){
						delete(rs.getInt("id"),rs.getInt("pid"),rs.getInt("isleaf")==0?true:false);
					}
			}catch(SQLException e){
						e.printStackTrace();
					}finally  {
						DB.close(rs);
					}
		}
			DB.executeUpdate(conn, "delete from category where id ="+id);
			if(pid!=0)	{
				rs=DB.getResultSet(conn, "select * from category where id="+pid);
				int count = 0;
				try {
					if(rs.next()){
					count = rs.getInt(1);
					}
				} catch (SQLException e) {
					System.out.println("11111");
				}	
				if(count<=0){
					DB.executeUpdate(conn,"update category set isleaf = 0 where id ="+pid);
				}
				
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e1) {
			System.out.println("22222");
		}	finally {
			DB.close(rs);
			DB.close(conn);
		}
	}
}

