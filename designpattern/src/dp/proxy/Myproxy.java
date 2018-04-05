package dp.proxy;
import java.lang.reflect.Method;
public class Myproxy implements dp.proxy.Movable{
	dp.proxy.InvocationHander h;
	public Myproxy(InvocationHander h) {
		this.h = h;
	}
	public void move() {
	try{
	Method md = dp.proxy.Movable.class.getMethod("move");
    h.invoke(this,md);
	} catch(Exception e){
	e.printStackTrace();
	}
}
}