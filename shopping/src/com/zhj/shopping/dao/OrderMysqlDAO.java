package com.zhj.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zhj.shopping.Cary;
import com.zhj.shopping.CaryList;
import com.zhj.shopping.DB;
import com.zhj.shopping.Order;
import com.zhj.shopping.User;

public class OrderMysqlDAO {

	public void save(Order o) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			conn.setAutoCommit(false);
			String sql = "insert into salesorder values (null, ?, ?, ?, ?)";
			pstmt = DB.prepare(conn,sql,true);
			pstmt.setInt(1,o.getUser().getId());
			pstmt.setString(2,o.getAddr());
			pstmt.setTimestamp(3,o.getOdate());
			pstmt.setInt(4,o.getStatus());
			pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			rs.next();
			int key = rs.getInt(1);
			pstmt.close();
			String sqlitem = "insert into salesitem values (null, ?, ?, ?, ?)";
			pstmt = DB.prepare(conn, sqlitem);
			CaryList CaryList = new CaryList();
			CaryList = o.getCarylist();
			List<Cary> caries = CaryList.getCaries();
			for(int i=0;i<caries.size();i++){
				Cary c = caries.get(i);
				pstmt.setInt(1, c.getId());
				pstmt.setDouble(2, c.getPrice());
				pstmt.setInt(3, c.getCount());
				pstmt.setInt(4, key);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(pstmt);
			DB.close(conn);
		}
		
	}

	public List<Order> getorders() {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = null;
		ResultSet rs = null;
		try{
			conn=DB.getConn();
			String sql ="select salesorder.id,salesorder.userid,salesorder.addr,salesorder.odate,salesorder.status,"+
					"user.id uid,user.username,user.password,user.phone,user.addr uaddr,user.rdate "+
					"from salesorder left join user on (salesorder.userid = user.id)";
			rs=DB.getResultSet(conn,sql);
			while(rs.next()){
				Order o = new Order();
				o.setId(rs.getInt("id"));
				o.setAddr(rs.getString("addr"));
				o.setOdate(rs.getTimestamp("odate"));
				o.setStatus(rs.getInt("status"));
				User u = new User();
				u.setId(rs.getInt("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAddr(rs.getString("uaddr"));
				u.setPhone(rs.getString("phone"));
				u.setRdate(rs.getTimestamp("rdate"));
				o.setUser(u);
				orders.add(o);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DB.close(rs);
			DB.close(conn);
			
		}
		return orders;
	}

}
