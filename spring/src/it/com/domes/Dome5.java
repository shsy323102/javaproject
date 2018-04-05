package it.com.domes;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import it.com.bean.UserName;
import it.com.dao.UserNameDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Dome5 {
	@Resource(name="userNameDao")
	private UserNameDao ud;
	@Test
	public void fun1(){
		UserName u =new UserName();
		u.setName("asd");
		ud.save(u);
	}
	
	
	@Test
	public void fun4() throws Exception{
		ud.delete(2);
	}
	
	@Test
	public void fun5() throws Exception{
		System.out.println(ud.getCount());
	}
	
	@Test
	public void fun6() throws Exception{
		System.out.println(ud.getById(1));
	}
	
	@Test
	public void fun7() throws Exception{
		System.out.println(ud.getAll());
	}
}
