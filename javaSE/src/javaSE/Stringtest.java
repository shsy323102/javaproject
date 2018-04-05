package javaSE;
public class Stringtest {

	public static void main(String[] args) {
		
		Stringtest.Dome1();
		Stringtest.Dome2();
		Stringtest.Dome3();
		Stringtest.Dome4();
	}
	public  static void Dome1(){
		String str1 ="abc";
		String str2 =new String("abc");
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
	}
	public static void Dome2(){
		byte[] b= {67,97,98,89};
		System.out.println(new String(b));
	}
	public static void Dome3(){
		String str1 ="abcasdaqewenewigwehh";
		System.out.println(str1.indexOf("c"));
		System.out.println(str1.charAt(6));
	}
	public static void Dome4(){
		StringBuffer sbf = new StringBuffer();//线程安全
		StringBuilder sbd = new StringBuilder();//非线程安全
		sbf.append("asdasdwrewqrqwer");
		sbf.append(true);
		sbf.replace(2, 5, "a");
		sbf.deleteCharAt(2);
		System.out.println(sbf);
		
	}
	

}
