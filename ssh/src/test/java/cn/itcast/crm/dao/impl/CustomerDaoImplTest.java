package cn.itcast.crm.dao.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;

public class CustomerDaoImplTest {

	@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CustomerDao customerDao = (CustomerDao) app.getBean("customerDao");
		Customer customer = customerDao.findById(2L);
		System.out.println("********************"+customer.getCustName());
	}

}
