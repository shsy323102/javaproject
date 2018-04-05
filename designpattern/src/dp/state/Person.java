package dp.state;

public class Person {
	State state;
	public Person(State state) {
		super();
		this.state = state;
	}
	public void say(){
		state.say();
	}
	public void smile(){
		state.smile();
	}
}
