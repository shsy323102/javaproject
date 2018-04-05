package dp.strategy;

public class Cat implements Comparable {
	public Cat(int age) {
		this.age = age;
	}

	int age;
	Comparetor comparetor = new CatIdComparetor();
	public Comparetor getComparetor() {
		return comparetor;
	}

	public void setComparetor(Comparetor comparetor) {
		this.comparetor = comparetor;
	}

	public int compareto(Object o) {
	
		return getComparetor().comparetor(this, o);
	}

	@Override
	public String toString() {
	
		return "cat:"+age;
	}

}
