package it.com.domes;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import it.com.service.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Dome6 {
	@Resource(name="accountService")
	private AccountService accountService;
	@Test
	public void fun(){
		accountService.transfer(1, 2, 100d);
	}
	
	
}
