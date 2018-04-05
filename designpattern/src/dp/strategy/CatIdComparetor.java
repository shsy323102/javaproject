package dp.strategy;

public class CatIdComparetor implements Comparetor{

	
	public int comparetor(Object o1, Object o2) {
		Cat c1 = (Cat)o1;
		Cat c2 = (Cat)o2;
		if(c1.age>c2.age){
			return 1;
		} else if(c1.age<c2.age){
			return -1;
		} else {
			return 0;
		}
	}
}
