package javaSE;

public class Datetypetest {
	static int x = Integer.parseInt("123");
	static int y = Integer.parseInt("2312");
	static double z = Double.parseDouble("1e10");
	static int a = Integer.parseInt("2512");
	public static void main(String[] args) {
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(a);
		System.out.println(Integer.toBinaryString(123));
		System.out.println(Integer.toString(2,2));
		Integer a = new Integer(2);
		Integer b = new Integer(3);
		System.out.println(a.compareTo(b));
		System.out.println(a.intValue());
	}
		
		
	
}
