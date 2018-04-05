import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Yard extends Frame{
	Yard (){
		isOver =  false;
		ispause = false;
		colortype=1;
		createMap();
		run();
		
	}
    public static final int WIDE=12;
    public static final int HIGHT=17;
    public static final int SIZE =40;
    private boolean isOver;
    private boolean ispause;
    private int colortype;
    Image mymage;
    public static int[][] map= new int[HIGHT][WIDE];
    square s = new square(this);
    public void createsquare()
    {
    	s = new square(this);
    }
    public void run()
    {
    	
    	this.setLocation(800,50);
    	this.setSize(WIDE*SIZE,HIGHT*SIZE);
    	this.setBackground(Color.WHITE);
    	this.setResizable(false);
    	this.addWindowListener(new WindowAdapter() {
    		
			public void windowClosing(WindowEvent e) {
			
				System.exit(0);
			}
    	
		});
    	this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				s.keyPressed(e);
			}
    		
		});
    	new Thread(new Reflash()).start();
    	this.setVisible(true);
    }
    public void createMap()
    {
    	int i,j;
    	for(i=0;i<HIGHT;i++)
    	{
    		for(j=0;j<WIDE;j++)
    		{
    			if(i==HIGHT-1||j==0||j==WIDE-1)
    			{
    				map[i][j]=2;
    			}
    			else
    			{
    				map[i][j]=0;
    			}
    		}
    	}
    
    }
    public void update(Graphics g) 
   	{
   		if(mymage==null)
   		{
   			mymage=this.createImage(WIDE*SIZE,HIGHT*SIZE);
   		}
   		Graphics a = mymage.getGraphics();
   		Color c = a.getColor();
   		a.setColor(Color.WHITE);
   		a.fillRect(0, 0,WIDE*SIZE,HIGHT*SIZE);
   		a.setColor(c);
   		paint(a);
   		g.drawImage(mymage, 0, 0, null);
   	}
   public void paint(Graphics g)
    {
	  	Color c = g.getColor();
    	s.draw(g);
    	/*for(int i=0;i<HIGHT;i++)
    	{
    		for(int j=0;j<WIDE;j++)
    		{
    			System.out.print(map[i][j]+"    ");
    		}
    		System.out.println();
    	}*/
    	
    	for(int i=0;i<HIGHT;i++)
    	{
    		for(int j=0;j<WIDE;j++)
    		{
    			if(map[i][j]==2)
    			{
    				g.setColor(Color.LIGHT_GRAY);
    				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
    			}
    			else if(map[i][j]==1)
    			{
    				g.setColor(Color.GREEN);
    				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
    			}
    			else if(map[i][j]==3)
    			{
    				if(colortype>0)
    				{
    					g.setColor(Color.GRAY);
        				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
    				}
    				else
    				{
    					g.setColor(Color.WHITE);
        				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
    				}
    				
    			}	
    		}
    	}
    	colortype*=-1;
    	g.setColor(Color.BLUE);
		g.setFont(new Font("ËÎÌו",Font.BOLD,20));
		g.drawString("author:chenfu",WIDE*SIZE-185,50);
		g.drawString("Version:v1.0",WIDE*SIZE-185,65);
    	if(isOver==true)
    	{
    		g.setColor(Color.red);
    		g.setFont(new Font("ËÎÌו",Font.BOLD,40));
    		g.drawString("Game Over",WIDE*SIZE/2-100,HIGHT*SIZE/2);
//			System.out.println("Game Over");
    	}
    	g.setColor(c);
    }
   public void delete()
   {
	   int k=0;
	   for(int i=HIGHT-1;i>=0;i--)
   	{
   		for(int j=0;j<WIDE;j++)
   		{
   			if(map[i][j]==1)
   			{
   				k++;
   			}
   			
   		}
   			if(k==WIDE-2)
   			{
   				deleteffect(i);
//   				System.out.println(i);
   				for(int a=i;a>0;a--)
   				{
   					
   					for(int b=0;b<WIDE;b++)
   					{
   						map[a][b]=map[a-1][b];
   					}
   				}
   			/*	for(int a=0;a<HIGHT;a++)
   				{
   					for(int b=0;b<WIDE;b++)
   					{
   						System.out.print(map[a][b]+"  ");
   					}
   					System.out.println();
   				}
   				System.out.println();*/
   				i++;
   			}
   		k=0;
   	}
  }
	public boolean isOver() {
	return isOver;
}
public void setOver(boolean isOver) {
	this.isOver = isOver;
}
public void deleteffect(int i)
{

	for(int j=1;j<WIDE-1;j++)
	{
		map[i][j]=3;
	}
//	System.out.print(i);
	Reflash r = new Reflash();
	r.pause(500);
}
	public static void main(String[] args) {
			new Yard();
	}
	 public void gameOver()
	  {
		 	for(int i=0;i<WIDE;i++)
		 	{
		 		if(map[1][i]==1)
		 		{
		 			isOver=true;
//	 			System.out.println("Game Over");
		 		}
		 	}
	  }
	 class Reflash implements Runnable
	 {
         
		public void run() {
			while(!isOver)
			{
				try {
					s.down();
					if(!ispause)
					{
						repaint();
					}
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		public void pause(int i)
		{
			try {
				ispause=true;
				for(int count=0;count<10;count++)
				{
				repaint();
				Thread.sleep(i/10);
				}
				ispause=false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
