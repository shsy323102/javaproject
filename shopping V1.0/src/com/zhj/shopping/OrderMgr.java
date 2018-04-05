package com.zhj.shopping;

public class OrderMgr {
	private static OrderMgr om;
	static {
		if(om==null){
			om = new OrderMgr();
		}
	}
}
