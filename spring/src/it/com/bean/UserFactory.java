package it.com.bean;

public class UserFactory {
	
	public static User createUser(){
		System.out.println("static user");
		return new User("",new Car());
	}
	public User createUser2(){
		System.out.println("dynamic user");
		return new User("",new Car());
	}
}
