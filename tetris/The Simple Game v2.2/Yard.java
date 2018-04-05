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
		score=0;
		speed=500;
		createMap();
		run();	
	}
    public static final int WIDE=12;
    public static final int HIGHT=17;
    public static final int SIZE =40;
    public static final int DISSAPPEARCOUNT=3;
    public static final Color mapcolor1 = new Color(120,120,255);
    public static final Color mapcolor4 = new Color(181,200,181);
    public static final Color mapcolor2 = new Color(88,88,88);
    private int score;
    private int speed;
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
    	
    	this.setVisible(true);
    	Reflash R=new Reflash();
    	new Thread(R).start();
    	this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				s.keyPressed(e);
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_R)
				{
					createMap();
					isOver=false;
					score=0;
					new Thread(R).start();
				}
				else if(key==KeyEvent.VK_D)
				{
					createMap();
				}
			}
    		
		});
    	
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
    	drawMap(g);
    	g.setColor(Color.BLUE);
		g.setFont(new Font("ËÎÌו",Font.BOLD,20));
    	g.drawString("Score:"+score,WIDE*SIZE-150,50);
    	if(isOver==true)
    	{
    		g.setColor(Color.BLUE);
    		g.setFont(new Font("ËÎÌו",Font.BOLD,20));
    		g.drawString("author:chenfu",WIDE*SIZE/2-80,HIGHT*SIZE/2+20);
    		g.drawString("Version:v2.2",WIDE*SIZE/2-80,HIGHT*SIZE/2+40);
    		g.setColor(Color.red);
    		g.setFont(new Font("ËÎÌו",Font.BOLD,40));
    		g.drawString("Game Over",WIDE*SIZE/2-100,HIGHT*SIZE/2);
    	}
    	g.setColor(c);
    }
   public void drawMap(Graphics g)
   {
	   for(int i=0;i<HIGHT;i++)
   	{
   		for(int j=0;j<WIDE;j++)
   		{
   			if(map[i][j]==4)
   			{
   				g.setColor(mapcolor4);
   				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
   			}
   			else if(map[i][j]==2)
   			{
   				g.setColor(mapcolor2);
   				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
   			}
   			else if(map[i][j]==1)
   			{
   				g.setColor(mapcolor1);
   				g.fillRect(j*SIZE, i*SIZE, SIZE, SIZE);
   			}
   			else if(map[i][j]==3||map[i][j]==5)
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
   }
   public void deleteslant()
   {
	   for(int i=HIGHT-1;i>=0;i--)
		{
			for(int j=WIDE-1;j>=0;j--)
			{
				if(checkRow(i, j)==true||checkLine(i, j)==true||
				checkRightDiagonal(i, j)==true||checkBackDiagonal(i, j)==true)
				{
					checkEmptyGrid();
				}
			}
		}
   }
   public boolean checkRightDiagonal(int i,int j)
	{
	   		int count1=0;
	  		while(map[i-count1][j-count1]==4)
				{
					count1++;
					if(i-count1<0||j-count1<0)
					{
						break;
					}
				}
	  		if(count1>DISSAPPEARCOUNT)
			{
				deleteEffect(i, j,count1, 2);
				for(int k=0;k<count1;k++)
				{
					map[i-k][j-k]=4;
					checkBackDiagonal(i-k,j-k);
					checkLine(i-k, j-k);
					checkRow(i-k, j-k);
					map[i-k][j-k]=0;
				}
				return true;
			}	
	  		int count2=0;
	  		while(map[i+count2][j+count2]==4)
			{
				count2++;
				if(i+count2>HIGHT-1||j+count2>WIDE-1)
				{
					break;
				}
				
			}
				if(count2>DISSAPPEARCOUNT)
				{
					deleteEffect(i, j,count2, 6);
					for(int k=0;k<count2;k++)
					{
						map[i+k][j+k]=4;
						checkBackDiagonal(i+k,j+k);
						checkLine(i+k, j+k);
						checkRow(i+k, j+k);
						map[i+k][j+k]=0;
					}
					return true;
				}
			return false;
	} 
		public boolean checkBackDiagonal(int i,int j)  
	{
			int count1=0;
			while(map[i-count1][j+count1]==4)
			{
				count1++;
				if(i-count1<0||j+count1>WIDE-1)
				{
					break;
				}
			
			}
			if(count1>DISSAPPEARCOUNT)
			{
                deleteEffect(i, j, count1,3);
            	for(int k=0;k<count1;k++)
				{
            		map[i-k][j+k]=4;
            		checkRightDiagonal(i-k, j+k);
            		checkLine(i-k, j+k);
            		checkRow(i-k, j+k);
					map[i-k][j+k]=0;
				}
            	return true;
			}
			int count2=0;
			while(map[i+count2][j-count2]==4)
			{
				count2++;
				if(i+count2>HIGHT-1||j-count2<0)
				{
					break;
				}
			
			}
			if(count2>DISSAPPEARCOUNT)
			{
                deleteEffect(i, j, count2,7);
            	for(int k=0;k<count2;k++)
				{
            		map[i+k][j-k]=4;
            		checkRightDiagonal(i+k, j-k);
            		checkLine(i+k, j-k);
            		checkRow(i+k, j-k);
			map[i+k][j-k]=0;
				}
            	return true;
			}
		return false;
	}
		public boolean checkLine(int i,int j)  
	{
			int count1=0;
			while(map[i-count1][j]==4)
		{
			count1++;
			if(i-count1<0)
				break;
			
		}
			if(count1>DISSAPPEARCOUNT)
			{
				deleteEffect(i, j, count1, 4);
				for(int k=0;k<count1;k++)
				{	
					map[i-k][j]=4;
					checkRightDiagonal(i-k, j);
					checkBackDiagonal(i-k, j);
					checkRow(i-k, j);
					map[i-k][j]=0;
				}
				return true;
			}
			int count2=0;
			while(map[i+count2][j]==4)
		{
			count2++;
			if(i+count2>HIGHT-1)
				break;
			
		}
			if(count2>DISSAPPEARCOUNT)
			{
				deleteEffect(i, j, count2, 8);
				for(int k=0;k<count2;k++)
				{	
					map[i+k][j]=4;
					checkRightDiagonal(i+k, j);
					checkBackDiagonal(i+k, j);
					checkRow(i+k, j);
					map[i+k][j]=0;
				}
				return true;
			}
		return false;
	}
	public boolean checkRow(int i, int j) {
		int count1 = 0;
		while (map[i][j - count1] == 4) {
			count1++;
			if (j - count1 < 0)
				break;

		}
		if (count1 > DISSAPPEARCOUNT)
		{
			deleteEffect(i, j, count1, 5);
			for (int k = 0; k < count1; k++)
			{
				map[i][j-k] = 4;
				checkRightDiagonal(i, j-k);
				checkBackDiagonal(i, j-k);
				checkLine(i, j-k);
				map[i][j-k] = 0;
			}
			return true;
		}
		int count2 = 0;
		while (map[i][j + count2] == 4) {
			count2++;
			if (j + count2 < 0)
				break;

		}
		if (count2 > DISSAPPEARCOUNT)
		{
			deleteEffect(i, j, count2, 9);
			for (int k = 0; k < count2; k++)
			{
				map[i][j+k] = 4;
				checkRightDiagonal(i, j+k);
				checkBackDiagonal(i, j+k);
				checkLine(i, j+k);
				map[i][j+k] = 0;
			}
			return true;
		}
		return false;
	}

	public void deleteLine() {
		int k = 0;
		for (int i = HIGHT - 1; i >= 0; i--) {
			for (int j = 0; j < WIDE; j++) {
				if (map[i][j] == 1) {
					k++;
				}

			}
			if (k == WIDE - 2) {
				score += 10;
				deleteEffect(i, 0, 0, 1);
				for (int a = i; a > 0; a--) {

					for (int b = 0; b < WIDE; b++) {
						map[a][b] = map[a - 1][b];
					}
				}
				i++;
			}
			k = 0;
		}
	}
   public void checkEmptyGrid()
   {
	   int k;
	   boolean empty;
	   for(int i=HIGHT-1;i>=0;i--)
		{
			for(int j=WIDE-1;j>=0;j--)
			{
				k=0;
				empty=false;
			   if(map[i][j]==1||map[i][j]==4)
			   {
				   	while(map[i+k+1][j]==0)
				   	{
				   		empty=true;
				   		if(i+k>HIGHT)
				   		break;
				   		k++;
					}
				   	if(empty==true)
				   	{
				   		map[i+k][j]=map[i][j];
				   		map[i][j]=0;
				   		empty=false;
				   	}
			   }
			}
		}
   }
	public boolean isOver() {
	return isOver;
}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	public void deleteEffect(int i,int j,int count,int type)
	{
			Reflash r = new Reflash();
		switch (type)
		{
		case 1 :deleteLineEffect(i);
				r.pause(500);
				break;
		case 2 :
			for(int k=0;k<count;k++)
			{
				map[i-k][j-k]=5;
			}
				r.pause(500);
				break;
		case 3 :
			for(int k=0;k<count;k++)
			{
				map[i-k][j+k]=5;
			}
				r.pause(500);
				break;
		case 4:
			for(int k=0;k<count;k++)
			{
				map[i-k][j]=5;
			}
			r.pause(500);
				break;
		case 5:
			for(int k=0;k<count;k++)
			{
				map[i][j-k]=5;
			}
			r.pause(500);
				break;
		case 6 :
			for(int k=0;k<count;k++)
			{
				map[i+k][j+k]=5;
			}
				r.pause(500);
				break;
		case 7 :
			for(int k=0;k<count;k++)
			{
				map[i+k][j-k]=5;
			}
				r.pause(500);
				break;
		case 8:
			for(int k=0;k<count;k++)
			{
				map[i+k][j]=5;
			}
			r.pause(500);
				break;
		case 9:
			for(int k=0;k<count;k++)
			{
				map[i][j+k]=5;
			}
			r.pause(500);
				break;
		}
	}
	public void deleteLineEffect(int i)
	{
		for(int j=1;j<WIDE-1;j++)
		{
			map[i][j]=3;
		}
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
					if(score<=300)
					{
						Thread.sleep(speed-score);
					}
					else
					{
						Thread.sleep(200);
					}
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
