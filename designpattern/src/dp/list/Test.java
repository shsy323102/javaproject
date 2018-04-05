package dp.list;

public class Test {
	public static void main(String[] args) {
		  Mycollection c = new Linklist();
		 for(int i=0;i<15;i++){
			 Dog dog = new Dog(i);
			 c.add(dog);
		 }
		for(Myiterator it = c.iterator();it.hasnext();){
			Dog dog =(Dog)it.next();
			System.out.println("dog"+dog.id);
		}
	}
}
