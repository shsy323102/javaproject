package dp.spring.factory;

import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception{
	
		Properties prop = new Properties();
		prop.load(Test.class.getClassLoader().getResourceAsStream("dp/spring/factory/spring.properties"));
		String v = prop.getProperty("vehicletype");
		Object o= Class.forName(v).newInstance();
		Movable c = (Movable)o;
		c.run();
		
	}

}
