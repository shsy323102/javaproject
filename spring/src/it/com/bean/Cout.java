package it.com.bean;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cout")
public class Cout {
	@Value("tom")
	private String name;
	private Integer age;
	@Resource(name="car2")
	private Car car;
	
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
		return "Cout [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
