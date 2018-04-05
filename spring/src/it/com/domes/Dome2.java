package it.com.domes;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import it.com.bean.CollectionBean;
import it.com.bean.Cout;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Dome2 {
	@Resource(name="cout")
	private Cout cout;
	@Test
	public void fun1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("/it/com/bean/applicationContext.xml");
		CollectionBean cb = (CollectionBean) ac.getBean("cb");
		System.out.println(cb);
	}
	@Test
	public void fun2(){
		
		System.out.println(cout);
	}
	
}
