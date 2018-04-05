package it.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import it.com.bean.UserName;
import it.com.dao.UserNameDao;

public class UserNameDaoImp implements UserNameDao{
	 
	private JdbcTemplate jc;
	public JdbcTemplate getJc() {
		return jc;
	}
	public void setJc(JdbcTemplate jc) {
		this.jc = jc;
	}
	public void save(UserName u){
		String sql = "insert into username values(null,?)";
		jc.update(sql, u.getName());
	}
	public void delete(Integer id){
		String sql = "delete from username where id = ? ";
		jc.update(sql,id);
	}
	public void update(UserName u){
		String sql ="update username set name = ? where id = ?";
		jc.update(sql, u.getName(),u.getId());
	}
	public UserName getById(Integer id){
		String sql ="select * from username where id = ?";
		UserName username = jc.queryForObject(sql, new RowMapper<UserName>() {

			@Override
			public UserName mapRow(ResultSet rs, int arg1) throws SQLException {
				UserName u = new UserName();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				return u;
			}
		}, id);
		return username;	
	}
	public int getCount(){
		String sql ="select count(*) from username";
		Integer count = jc.queryForObject(sql,Integer.class);
		return count;
	}
	public List<UserName> getAll(){
		String sql ="select * from username";
		List<UserName> list = jc.query(sql, new RowMapper<UserName>() {

			@Override
			public UserName mapRow(ResultSet rs, int arg1) throws SQLException {
				UserName u = new UserName();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				return u;
			}
		});
		return list;
	}
}
