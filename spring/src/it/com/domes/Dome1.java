package it.com.domes;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.com.bean.User;

public class Dome1 {
	@Test
	public void fun1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u1 = (User) ac.getBean("user1");
		User u2 = (User) ac.getBean("user2");
		User u3 = (User) ac.getBean("user3");
		
		System.out.println(u1);
	}
	@Test
	public void fun2(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/it/com/bean/applicationContext.xml");
		User u1 = (User) ac.getBean("user");
		ac.close();
		System.out.println(u1);
	}
	@Test
	public void fun3(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/it/com/bean/applicationContext.xml");
		User u1 = (User) ac.getBean("user2");
		ac.close();
		System.out.println(u1);
	}
}
