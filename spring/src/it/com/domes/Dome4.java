package it.com.domes;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Dome4 {
	
	@Test
	public void fun1() throws Exception{
		
		ComboPooledDataSource Datasourse = new ComboPooledDataSource();
		Datasourse.setDriverClass("com.mysql.jdbc.Driver");
		Datasourse.setJdbcUrl("jdbc:mysql:///bank");
		Datasourse.setUser("root");
		Datasourse.setPassword("root");
		
		JdbcTemplate jc = new JdbcTemplate();
		jc.setDataSource(Datasourse);
		
		String sql="insert into username values(null,'tom')";
		jc.update(sql);
		
	}
	
}
