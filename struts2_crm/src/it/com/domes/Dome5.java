package it.com.domes;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import it.com.domain.User;
import ognl.Ognl;
import ognl.OgnlContext;
public class Dome5{
	/*
	@Test
	public void fun1() throws Exception{
		User uroot = new User(12l,"tom");
		Map<String,User> context = new HashMap<String,User>();
		context.put("user1",new User(1l,"aim"));
		context.put("user2",new User(2l,"jane"));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(uroot);
		oc.setValues(context);
		String name =(String)Ognl.getValue("user_name", oc,oc.getRoot());
		String name2 =(String)Ognl.getValue("#user1.user_name", oc,oc.getRoot());
		System.out.println(name);
		System.out.println(name2);
		
	}
	@Test
	public void fun2() throws Exception{
		User uroot = new User(12l,"tom");
		Map<String,User> context = new HashMap<String,User>();
		context.put("user1",new User(1l,"aim"));
		context.put("user2",new User(2l,"jane"));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(uroot);
		oc.setValues(context);
		String name =(String)Ognl.getValue("user_name='jery'", oc,oc.getRoot());
		System.out.println(name);
		String name2 =(String)Ognl.getValue("getUser_name()", oc,oc.getRoot());
		System.out.println(name2);
		double pi = (double)Ognl.getValue("@java.lang.Math@PI", oc,oc.getRoot());
		System.out.println(pi);
	}
	@Test
	public void fun3() throws Exception{
		User uroot = new User(12l,"tom");
		Map<String,User> context = new HashMap<String,User>();
		context.put("user1",new User(1l,"aim"));
		context.put("user2",new User(2l,"jane"));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(uroot);
		oc.setValues(context);
		Integer size = (Integer) Ognl.getValue("{'a','b','c','d'}.size()", oc,oc.getRoot());	
		System.out.println(size);
		Integer value = (Integer) Ognl.getValue("#{'a':'tom','age':18}.size()", oc,oc.getRoot());
		System.out.println(value);
		String name = (String) Ognl.getValue("#{'a':'tom','age':18}['a']", oc,oc.getRoot());
		System.out.println(name);
	}*/
}
