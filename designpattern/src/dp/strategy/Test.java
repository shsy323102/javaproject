package dp.strategy;

public class Test {
	public static void main(String[] args) {
		Cat[] cats={new Cat(3),new Cat(1),new Cat(2)};
		DateSorter.sort(cats);
		DateSorter.print(cats);
	}
}
