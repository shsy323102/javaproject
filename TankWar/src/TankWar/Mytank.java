package TankWar;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
public class Mytank {
	private int x=50;
	private int y=50;
	private Boolean live=true;
	private int oldx;
	private int oldy;
	private int life=100;
	private static Random r= new Random();
	private int step=r.nextInt(15)+3;
	BloodBar m =new BloodBar();
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public Boolean getLive() {
		return live;
	}
	public void setLive(Boolean live) {
		this.live = live;
	}
	private Boolean good = true;
	public Boolean getGood() {
		return good;
	}
	Yard myyard =null;
	public static final int SPEED=5;
	public static final int WIDE =50;
	public static final int HIGHT =50;
	private Boolean ba=false,bs=false,bd=false,bw=false;
	Direction dir = Direction.STOP;
	Direction ptdir = Direction.D;
	public Mytank(int x, int y,boolean good) {
		this.x = x;
		this.y = y;
		this.oldx=x;
		this.oldy=y;
		this.good=good;
	}
	public Mytank(int x,int y,boolean good,Yard myyard)
	{
		this(x,y,good);
		this.myyard=myyard;
	}
	public  void draw(Graphics g)
	{
		if(!live) return;
		Color c =g.getColor();
		if(good==true)
		g.setColor(Color.blue);
		else g.setColor(Color.green);
		g.fillOval(x,y,WIDE, HIGHT);
		g.setColor(Color.BLACK);
		if(good)	m.draw(g);
			
		switch(ptdir)
		{
		case A:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x, y+Mytank.HIGHT/2);break;
		case AS:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x, y+Mytank.HIGHT);break;
		case AW:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x, y);break;
		case W:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x+Mytank.WIDE/2, y);break;
		case S:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x+Mytank.WIDE/2, y+Mytank.HIGHT);break;
		case D:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x+Mytank.WIDE, y+Mytank.HIGHT/2);break;
		case DW:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x+Mytank.WIDE, y);break;
		case DS:
			g.drawLine(x+Mytank.WIDE/2, y+Mytank.HIGHT/2, x+Mytank.WIDE, y+Mytank.HIGHT);break;
		}
		g.setColor(c);	
		remove();
	}
	public void remove()
	{
		oldx=x;
		oldy=y;
		switch(dir)
		{
		case A:x-=SPEED;break;
		case AS:x-=SPEED;y+=SPEED;break;
		case AW:x-=SPEED;y-=SPEED;break;
		case W:y-=SPEED;break;
		case S:y+=SPEED;break;
		case D:x+=SPEED;break;
		case DW:x+=SPEED;y-=SPEED;break;
		case DS:x+=SPEED;y+=SPEED;break;
		case STOP:break;
		}
		if(dir!=Direction.STOP)
			ptdir=dir;
		if(x<0) x=0;
		if(y<25) y=25;
		if(x>Yard.YARD_WIDE-Mytank.WIDE) x=Yard.YARD_WIDE-Mytank.WIDE;
		if(y>Yard.YRAD_HIGH-Mytank.HIGHT) y=Yard.YRAD_HIGH-Mytank.HIGHT;
		if(!good)
		{
			Direction[] dire = Direction.values();
			if(step==0){		
			int num = r.nextInt(dire.length);
			dir=dire[num];
			step=r.nextInt(15)+3;
			}
			step--;
			if(r.nextInt(30)>28)
			{
				fire();
			}
		}
	}
	public void move(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code)
		{
		case KeyEvent.VK_F2:
			if(good){
				this.setLife(100);
				this.setLive(true);
			}
			break;
		case KeyEvent.VK_A:
		  superfire();break;
		case KeyEvent.VK_X:
			fire();break;
		case KeyEvent.VK_UP:
			bw=true;break;
		case KeyEvent.VK_DOWN:
			bs=true;break;
		case KeyEvent.VK_LEFT:
			ba=true;break;
		case KeyEvent.VK_RIGHT:
			bd=true;break;	
		}
		TankDirection();
	}
	public void keyrelessed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code)
		{
		case KeyEvent.VK_UP:
			bw=false;break;
		case KeyEvent.VK_DOWN:
			bs=false;break;
		case KeyEvent.VK_LEFT:
			ba=false;break;
		case KeyEvent.VK_RIGHT:
			bd=false;break;	
		}
		TankDirection();
	}
	public void TankDirection()
	{
		if(ba&&!bs&&!bd&&!bw)dir=Direction.A;
		else if(!ba&&bs&&!bd&&!bw)dir=Direction.S;
		else if(!ba&&!bs&&bd&&!bw)dir=Direction.D;
		else if(!ba&&!bs&&!bd&&bw)dir=Direction.W;
		else if(ba&&bs&&!bd&&!bw)dir=Direction.AS;
		else if(ba&&!bs&&!bd&&bw)dir=Direction.AW;
		else if(!ba&&bs&&bd&&!bw)dir=Direction.DS;
		else if(!ba&&!bs&&bd&&bw)dir=Direction.DW;
		else if(!ba&&!bs&&!bd&&!bw)dir=Direction.STOP;
		
	}
	public MIssble fire(){
		if(!live)
		return null;
		int x = this.x+Mytank.WIDE/2-MIssble.WIDE/2;
		int y = this.y+Mytank.HIGHT/2-MIssble.HIGHT/2;
		MIssble m = new MIssble(x,y,good,ptdir,this.myyard);
		myyard.MIssbles.add(m);
		return m;
		
	}

	public MIssble fire(Direction dir){
		if(!live)
			return null;
			int x = this.x+Mytank.WIDE/2-MIssble.WIDE/2;
			int y = this.y+Mytank.HIGHT/2-MIssble.HIGHT/2;
			MIssble m = new MIssble(x,y,good,dir,this.myyard);
			myyard.MIssbles.add(m);
			return m;
		
	}
	public void superfire(){
		Direction[] dirs = Direction.values();
		for(int i=0;i<dirs.length-1;i++)
		{
			fire(dirs[i]);
		}
	}
	public Rectangle getRect()
	{
		return new Rectangle(x,y,WIDE,HIGHT);
	}
	private void reset()
	{
		x=oldx;
		y=oldy;
	}
	public boolean hitWall(Wall w)
	{
		if(this.getRect().intersects(w.getRect())&&this.live)
		{
			this.reset();
			return true;
		}
		return false;
	}
	public boolean hitWithTanks(List<Mytank> tanks)
	{
		for(int i=0;i<tanks.size();i++)
		{
			Mytank t =tanks.get(i);
			if(this!=t)
			{
				if(this.getRect().intersects(t.getRect())&&this.live&&t.live)
				{
					this.reset();
					t.reset();
					return true;
				}	
			}
		}
		return false;
	}
	class BloodBar {
		public void draw(Graphics g)
		{
			Color c =g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x,y-15,WIDE, 8);
			int m=WIDE*life/100;
			g.fillRect(x, y-15,m,8);
			g.setColor(c);
		}
	}
	
}
