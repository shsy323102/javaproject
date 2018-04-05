package com.it.bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	public static final String  HOME = "home";
	protected T model;
	public BaseAction() {
		ParameterizedType p = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = p.getActualTypeArguments();
		Class clazz =(Class) actualTypeArguments[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public T getModel() {
		return model;
	}

}
