package it.com.domes;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import it.com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:it/com/aspect/applicationContext.xml")
public class Dome3 {
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun1(){
		us.save();
	}
	
}
