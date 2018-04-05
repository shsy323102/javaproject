package it.com.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CollectionBean {
	
	private List list;
	private Map map;
	private Properties properties;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	@Override
	public String toString() {
		return "CollectionBean [list=" + list + ", map=" + map + ", properties=" + properties + "]";
	}
	
}
