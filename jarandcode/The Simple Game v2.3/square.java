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
	private Random r = new Random();
	square(Yard yard)
	{
		x=0;
		y=4;
		SIZE=Yard.SIZE;
		state=r.nextInt(4);
		type=r.nextInt(2);
		this.yard=yard;
	}
	  private final int shapes[][][] = new int[][][] {
		 { 
		  	{ 0, 0, 0, 0, 4, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
		  	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 4, 0, 0 },
		 	{ 0, 0, 0, 0, 1, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 4, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
         },	
		 { 
 		  	{ 0, 0, 0, 0, 1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
 		  	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0 },
 		  	{ 0, 0, 0, 0, 1, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },	
         },	
		 
 };
	  public boolean isOk(int x,int y,int type ,int state)
	  {
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<4;j++)
			  {
				  if(
					 ((shapes[type][state][i*4+j]==1 || shapes[type][state][i*4+j]==4) && Yard.map[x+j][y+i]==1)||
					 ((shapes[type][state][i*4+j]==1 || shapes[type][state][i*4+j]==4)&& Yard.map[x+j][y+i]==2)||
					 ((shapes[type][state][i*4+j]==1 || shapes[type][state][i*4+j]==4)&& Yard.map[x+j][y+i]==4)
					 )
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
				  if((shapes[type][state][i*4+j]==1 ||shapes[type][state][i*4+j]==4) && Yard.map[x+j][y+i]==0)
				  {
					  Yard.map[x+j][y+i]=shapes[type][state][i*4+j];
				  }
			  }
		  }
		
	  }
	  public void nextstate(int state)
	  {
		  int nextstate= (state + 1 ) % 4;
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
			  yard.deleteslant();
			  yard.deleteLine(); 
		  }
		  	yard.gameOver();
	  		yard.victory();
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
		  for(int i=0;i<4;i++)
		  {
			  for(int j=0;j<4;j++)
			  {
				  if(shapes[type][state][i*4+j]==1)
				  {
					  g.setColor(Yard.mapcolor1);
					  g.fillRect((i+y)*SIZE, (j+x)*SIZE,SIZE,SIZE);
				  }
				  if(shapes[type][state][i*4+j]==4)
				  {
					  g.setColor(Yard.mapcolor4);
					  g.fillRect((i+y)*SIZE, (j+x)*SIZE,SIZE,SIZE);
				  }
			  }
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
