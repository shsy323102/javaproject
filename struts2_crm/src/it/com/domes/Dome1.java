package it.com.domes;

import com.opensymphony.xwork2.Action;

public class Dome1 implements Action{

	@Override
	public String execute() throws Exception {
		System.out.println("Dome1");
		return SUCCESS;
	}

}
