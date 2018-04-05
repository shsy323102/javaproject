package dp.proxy;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(@SuppressWarnings("rawtypes") Class infce,InvocationHander h) throws Exception {
	String rt="\r\n";
	String methodstr="";
	Method[] methods = infce.getMethods();
	for(Method m:methods){
		methodstr+=
				"	public void "+m.getName()+"() {"+rt+
				"	try{"+rt+
				"	Method md = "+infce.getName()+".class.getMethod(\""+m.getName()+"\");"+rt+
				"    h.invoke(this,md);"+rt+
				"	} catch(Exception e){"+rt+
				"	e.printStackTrace();"+rt+
				"	}"+rt+
				"}";
	}
	String src = 
	"package dp.proxy;"+rt+
	"import java.lang.reflect.Method;"+rt+
	"public class Myproxy implements " +infce.getName()+"{"+rt+
	"	dp.proxy.InvocationHander h;"+rt+
	"	public Myproxy(InvocationHander h) {"+rt+
	"		this.h = h;"+rt+
	"	}"+rt+
	methodstr+rt+
	"}";
	String filename = System.getProperty("user.dir")+"\\src\\dp\\proxy\\Myproxy.java";
	File f = new File(filename);
	FileWriter fw = new FileWriter(f);
	fw.write(src);
	fw.flush();
	fw.close();
	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	StandardJavaFileManager filemgr = compiler.getStandardFileManager(null, null, null);
	@SuppressWarnings("rawtypes")
	Iterable  Units = filemgr.getJavaFileObjects(filename);
	@SuppressWarnings("unchecked")
	CompilationTask t = compiler.getTask(null, filemgr, null, null, null, Units);
	t.call();
	filemgr.close();
	URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
	@SuppressWarnings("resource")
	URLClassLoader ul = new URLClassLoader(urls);
	@SuppressWarnings("rawtypes")
	Class c = ul.loadClass("dp.proxy.Myproxy");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	Constructor cst = c.getConstructor(InvocationHander.class);
	Object o = cst.newInstance(h);
	return o;
	}
}
