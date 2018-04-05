import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class Snack{
	Direction dire=Direction.D;
	private Yard y;
	ArrayList<Node> nodes = new ArrayList<Snack.Node>();
	Node n = new Node(25,20,dire);	
	 Snack(Yard y) {
		 nodes.add(n);
		 this.y=y;
	}
	
	 public void pressed(KeyEvent e) {
			int code = e.getKeyCode();
			
			switch(code)
			{
			case KeyEvent.VK_UP:
				if(dire!=Direction.S)dire=Direction.W;break;
			case KeyEvent.VK_DOWN:
				if(dire!=Direction.W)dire=Direction.S;break;
			case KeyEvent.VK_RIGHT:
				if(dire!=Direction.A)dire=Direction.D;break;
			case KeyEvent.VK_LEFT:
				if(dire!=Direction.D)dire=Direction.A;break;	
			}
		}
		
	public void draw(Graphics g)
	{
		isDead();
		for(int i=0;i<nodes.size();i++)
		{
			Node n = nodes.get(i);
			n.draw(g);
		}
		remove();
	}

	public void add()
	{
		 Node node =nodes.get(nodes.size()-1);
		Node n =null;
		switch(node.dir)
		{
		case A:
			n=new Node(node.x-1,node.y,node.dir);break;
		case D:
			n=new Node(node.x+1,node.y,node.dir);break;
		case S:
			n=new Node(node.x,node.y+1,node.dir);break;
		case W:
			n=new Node(node.x,node.y-1,node.dir);break;
		}
		nodes.add(n);		
	}
	public void remove()
	{
		add();
		nodes.remove(0);
	}
	public void	eat(Food food)
	{
		if(this.getRect().intersects(food.getRect()))
		{
			food.reApprear();
			this.add();
			y.setSum(y.getSum()+100);
		}
	}
	public void isDead()
	{	
		 Node node =nodes.get(nodes.size()-1);
		if(node.x<0||node.y<0||node.x>Yard.WIDE||node.y>Yard.HIGHT)
			y.stop();
		if(nodes.size()!=1)
		{
			for(int i= 0;i<nodes.size()-2;i++)
			{
				Node n =nodes.get(i);
				if(n.x==node.x&&n.y==node.y)
					y.stop();
			}
		}
		
	}
	public Rectangle getRect()
	{	
		Node head=nodes.get(nodes.size()-1);
		return new Rectangle(head.x*head.SIZE, head.y*head.SIZE,head.SIZE,head.SIZE);
	}
	class Node{
		
		private int x;
		private int y;
		private int SIZE=Yard.SIZE;
		private Direction dir=dire;
		Node(int x, int y, Direction dir) {
			this.x = x;
			this.y = y;
			dir = dire;
		}
		
		public void draw(Graphics g)
		{
			
			Color c =g.getColor();
			g.setColor(Color.blue);
			g.fillRect(x*SIZE, y*SIZE,SIZE,SIZE);
			g.setColor(c);
		}
	
		
	}
	
}
