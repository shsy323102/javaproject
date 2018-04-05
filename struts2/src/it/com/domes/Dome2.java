package it.com.domes;

import com.opensymphony.xwork2.Action;

public class Dome2 implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("Dome2");
		return SUCCESS;
	}

}
