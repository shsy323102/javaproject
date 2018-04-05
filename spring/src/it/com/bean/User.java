package it.com.bean;

public class User {
	private String name;
	private Integer age;
	private Car car;
	
	public User(String name, Car car) {
		this.name = name;
		this.car = car;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void init(){
		System.out.println("init");
	}
	public void destroy(){
		System.out.println("destory");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
}

