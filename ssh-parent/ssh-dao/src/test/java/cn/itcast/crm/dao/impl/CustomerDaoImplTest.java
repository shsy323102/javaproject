package cn.itcast.crm.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {

	@Autowired
	private CustomerDao customerDao;
	@Test
	public void test() {
		Customer customer = customerDao.findById(2L);
		System.out.println("********************"+customer.getCustName());
	}

}
