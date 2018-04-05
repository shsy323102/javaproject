package it.com.domes;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
public class Dome4 extends ActionSupport{
	private String name;
	private Integer age;
	private Date date;
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("date:"+date);
		return "success";
	}

}
