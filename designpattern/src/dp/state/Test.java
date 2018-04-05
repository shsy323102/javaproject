package dp.state;

public class Test {
	public static void main(String[] args) {
		Person p = new Person(new Sorrowstate());
		p.say();
		p.smile();
	}
	
}
