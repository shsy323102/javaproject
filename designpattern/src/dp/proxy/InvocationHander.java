package dp.proxy;
import java.lang.reflect.Method;
public interface InvocationHander {
	public void invoke(Object o,Method m);
}
