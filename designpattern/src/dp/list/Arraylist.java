package dp.list;

public class Arraylist implements Mycollection{
	Object[] objects = new Object[10];
	private int index = 0;
	 public void add(Object o){
		 if(index==objects.length){
		 Object[] Arraylist = new Object[2*objects.length];
		 System.arraycopy( objects,0,Arraylist,0,objects.length);
		 objects=Arraylist;
		 }
		 objects[index]=o;
		 index++;
	 }
	 public int size(){
		 return index;
	 }
	
	public Myiterator iterator() {
	
		return new Arrayiterator();
	}
	class Arrayiterator implements Myiterator{
		int count = 0;
		
		public boolean hasnext() {
		if(count>=index)
			return false;
		return true;
		}

		@Override
		public Object next() {
			Object o = new Object();
			o = objects[count];
			count++;
			return o;
		}
		
	}
}


