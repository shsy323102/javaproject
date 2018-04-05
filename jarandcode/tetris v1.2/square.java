import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
public class square {
	private int x;
	private int y;
	private final int SIZE; 
	private int state;
	private int type;
	private Yard yard;
	private Color color;
	private Random r = new Random();
	square(Yard yard)
	{
		x=0;
		y=4;
		SIZE=Yard.SIZE;
		color=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		state=r.nextInt(4);
		type=r.nextInt(7);
		this.yard=yard;
	}
	  private final int shapes[][][] = new int[][][] 
			  {
		    // i
		            { { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
		                    { 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } },
		            // s
		            { { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },
		            // z
		            { { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
		            // j
		            { { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
		                    { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
		            // o
		            { { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
		            // l
		            { { 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		                    { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },
		            // t
		            { { 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
		                    { 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } } 
};
	  public boolean isOk(int x,int y,int type ,int state)
	  {
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<4;j++)
			  {
				  if((shapes[type][state][i*4+j]==1 && Yard.map[x+j][y+i]==1)||
					(shapes[type][state][i*4+j]==1 && Yard.map[x+j][y+i]==2))
				  {
					  return false;
				  }
			  }
		  }
		  return true;
	  }
	  public void add(int x,int y,int type,int state)
	  {
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<4;j++)
			  {
				  if(shapes[type][state][i*4+j]==1 && Yard.map[x+j][y+i]==0)
				  {
					  Yard.map[x+j][y+i]=shapes[type][state][i*4+j];
				  }
			  }
		  }
		
	  }
	  public void nextstate(int state)
	  {
		  int nextstate= (state + 1 ) %  4;
		  if(isOk(x,y,type,nextstate))
		  {
			  this.state = nextstate;
			  yard.repaint();
		  }
	  }
	  public void down()
	  {
		  if(isOk(x+1,y,type,state))
		  {
			  x=x+1;
		  }
		  else
		  {
			  add(x,y,type,state);
			  yard.createsquare();
			  yard.delete(); 	  
		  }
		  		yard.gameOver();
		  		yard.repaint();
	  }
	 
	  public void left()
	  {
		  if(isOk(x,y-1,type,state))
		  {
			  y--;
			  yard.repaint();
		  }
		 
	  }
	  public void right()
	  {
		  if(isOk(x,y+1,type,state))
		  {
			  y++;
			  yard.repaint();
		  }
	  } 
	  public void draw(Graphics g)
	  {
		  Color c=g.getColor();
		  g.setColor(color);
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<4;j++)
			  {
				  if(shapes[type][state][i*4+j]==1)
				  {
					  g.fillRect((i+y)*SIZE, (j+x)*SIZE,SIZE,SIZE);
				  }
//				  System.out.print(shapes[type][state][i*4+j]);
			  }
//			  System.out.println();
		  }
		  g.setColor(c);
	  }
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();
		 switch (key)
		 {
		 case KeyEvent.VK_UP:
			 nextstate(state);
			 break;
		 case KeyEvent.VK_DOWN:  
			 down();
			 break;
		 case KeyEvent.VK_LEFT:  
			 left();
			 break;
		 case KeyEvent.VK_RIGHT:  
			 right(); 
			 break;
		 }
		}
}
