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
    public static final int WIDE=50;
    public static final int HIGHT=40;
    public static final int SIZE =15;
    private boolean run = true;
    private int sum=0;
    public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	Image mymage;
    Food f = new Food();
    Snack s=new Snack(this);
    public void run()
    {
    	
    	this.setLocation(300,100);
    	this.setSize(WIDE*SIZE,HIGHT*SIZE);
    	this.setBackground(Color.gray);
    	this.setResizable(false);
    	this.addWindowListener(new WindowAdapter() {
    		
			public void windowClosing(WindowEvent e) {
			
				System.exit(0);
			}
    	
		});
    	this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				s.pressed(e);
			}
		});
    	new Thread(new Reflash()).start();
    	this.setVisible(true);
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
    	public	void paint(Graphics g)
    {
    	Color c = g.getColor();
    	g.setColor(Color.GREEN);
    	for(int i=1;i<HIGHT;i++)
    	g.drawLine(0, SIZE*i,WIDE*SIZE*i,SIZE*i);
    	for(int i=1;i<WIDE;i++)
    	g.drawLine(SIZE*i, 0,SIZE*i,SIZE*HIGHT);
    	g.setColor(Color.RED);
    	if(run==true)
    	{
    		
    		g.setFont(new Font("ËÎÌו",Font.BOLD,20));
    		g.drawString("score:"+sum,600,70);
    		s.eat(f);
        	f.draw(g);
        	s.draw(g);
    	}
    	if(run==false)
    	{
    		g.setFont(new Font("ËÎÌו",Font.BOLD,50));
    		g.drawString("game over",SIZE*WIDE/2-120, SIZE*HIGHT/2);
    		g.setFont(new Font("ËÎÌו",Font.BOLD,30));
    		g.drawString("score:"+sum,SIZE*WIDE/2-120, SIZE*HIGHT/2+50);
    		repaint();
    	}
    	g.setColor(c);
    	
    	
    }
    	public void stop()
    	{
    		run = false;
    	}
	public static void main(String[] args) {
		new Yard().run();
	}
	class Reflash implements Runnable{
         
		public void run() {
			while(run)
			{
				try {
					Thread.sleep(200);
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
