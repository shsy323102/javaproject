package com.zhj.shopping;

import java.util.ArrayList;
import java.util.List;

public class CaryList {
 
	private List<Cary> caries = new ArrayList<Cary>();

	public List<Cary> getCaries() {
		return caries;
	}

	public void setCaries(List<Cary> caries) {
		this.caries = caries;
	}
	public void add(Cary c){
		for(int i = 0;i<caries.size();i++){
			Cary c1 = new Cary(); 
			c1 = caries.get(i);
			if(c1.getId()==c.getId()){
				c1.setCount(c1.getCount()+1);
				return;
			}
		}
		caries.add(c);
	}
	public double getotalprice(){
		double totalprice = 0.0;
		for(int i = 0;i<caries.size();i++){
			Cary c1 = new Cary(); 
			c1 = caries.get(i);
		   totalprice+=c1.getSum();
			}
			return totalprice;
		}
}

