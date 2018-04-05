package dp.proxy;
import java.lang.reflect.Method;
import java.sql.Timestamp;

public class TimeHander implements InvocationHander {
	
	private Object target;
	public TimeHander(Object target) {
		this.target = target;
	}


	@Override
	public void invoke(Object o,Method m) {
		System.out.println("start"+new Timestamp(System.currentTimeMillis()));
		try {
			m.invoke(target);
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		System.out.println("stop"+new Timestamp(System.currentTimeMillis()));
	}

}
