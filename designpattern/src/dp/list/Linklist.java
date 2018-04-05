package dp.list;
public class Linklist implements Mycollection{
	node head = null;
	node tail = null;
	private int index = 0;
	public int size() {
		return index;
	}
	public void add(Object o){
		node n = new node(o,null);
		if(head==null){
			head = n;
			tail = n;
		} 
		tail.next= n;
		tail = n;
		index++;
	}
	class node{
		Object o;
		node next;
		public node(Object o, node next) {
			this.o = o;
			this.next = next;
		}	
	}
	@Override
	public Myiterator iterator() {
		
		return new Linkiterator();
	}
	class Linkiterator implements Myiterator{
		node n = head;
		public boolean hasnext() {
			if(head==null)
			return false;
			if(n.next==null)
			return false;
		return true;
		}

		public Object next() {
			n = n.next;
			return n.o;
		}
		
	}
}
