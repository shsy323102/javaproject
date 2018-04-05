package TankWar;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
public class Yard extends Frame{
	public static final int YARD_WIDE =	800;
	public static final int YRAD_HIGH =	600;
	Image mymage = null;
	Mytank Mytank = new Mytank(50,50,true,this);
	List<MIssble> MIssbles =new ArrayList<MIssble>();
	List<Explore> Explores =new ArrayList<Explore>();
	List<Mytank> tanks = new ArrayList<Mytank>();
	Wall w1 = new Wall(100,200,50,200,this);
	Wall w2 = new Wall(500,200,50,200,this);	
	public void creat()
	{
		for(int i=0;i<10;i++)
		{
			Mytank tank = new Mytank(50+70*(i+1),50,false,this);
			tanks.add(tank);
		}
		this.setLocation(300, 100);
		this.setResizable(false);
		this.setSize(YARD_WIDE,YRAD_HIGH);
		this.setTitle("TrankWar");
		this.setBackground(Color.gray);
		this.setVisible(true);
		new Thread(new Mydraw()).start();
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Mytank.move(e);
			}
			public void keyReleased(KeyEvent e)
			{
				Mytank.keyrelessed(e);
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
	}
	
	public void paint(Graphics g)
	{
		Mytank.draw(g);
		w1.draw(g);
		w2.draw(g);
		g.drawString("MIssble count:"+MIssbles.size(),Yard.YARD_WIDE-100,50 );
		g.drawString("Explore count:"+Explores.size(),Yard.YARD_WIDE-100,65);
		g.drawString("Pctank count:"+tanks.size(),Yard.YARD_WIDE-100,80);
		g.drawString("Mytank life:"+Mytank.getLife(),Yard.YARD_WIDE-100,95);
		if(Mytank.getLife()<=0){
			g.drawString("Game Over",Yard.YARD_WIDE/2,Yard.YRAD_HIGH/2);
			g.drawString("°´F2¼ÌÐøÓÎÏ·",Yard.YARD_WIDE/2,Yard.YRAD_HIGH/2+20);
		}
	
		for(int i=0;i<MIssbles.size();i++)
		{
			MIssble m =MIssbles.get(i);
			m.hitTanks(tanks);
			m.hitTank(Mytank);
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(g);
		}
		for(int i=0;i<Explores.size();i++)
		{
			Explore e =Explores.get(i);
			e.draw(g);
		}
		for(int i=0;i<tanks.size();i++)
		{
			Mytank a =tanks.get(i);
			a.draw(g);
			a.hitWithTanks(tanks);
			a.hitWall(w1);
			a.hitWall(w2);
		}
		if(tanks.size()<=0)
		{
			for(int i=0;i<5;i++)
			{
				Mytank tank = new Mytank(50+70*(i+5),50,false,this);
				tanks.add(tank);
			}
		}
	}
	public void update(Graphics g) 
	{
		if(mymage==null)
		{
			mymage=this.createImage(YARD_WIDE,YRAD_HIGH);
		}
		Graphics a = mymage.getGraphics();
		Color c = a.getColor();
		a.setColor(Color.gray);
		a.fillRect(0, 0, YARD_WIDE,YRAD_HIGH);
		a.setColor(c);
		paint(a);
		g.drawImage(mymage, 0, 0, null);
	}
	public static void main(String[] args) {
		Yard y = new Yard();
		y.creat();
	
	}
	
 	private class Mydraw implements Runnable
	{
		public void run() 
		{
			while(true)
			{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		
		}
	}
}


