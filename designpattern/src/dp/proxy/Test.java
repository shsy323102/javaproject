package dp.proxy;

public class Test {
	public static void main(String[] args) {
		
		try {
		Tank t = new Tank();
		InvocationHander h = new  TimeHander(t);
		Movable m=(Movable)Proxy.newProxyInstance(Movable.class,h);
		m.move();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
