package cn.itcast.crm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.service.CustomerService;
@ContextConfiguration(locations={"classpath:applicationContext-service.xml","classpath:applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

	@Autowired
	private CustomerService cs;
	@Test
	public void test() {
		
		Customer customer = cs.findById(2L);
		System.out.println("********************"+customer.getCustName());
	}


}
