package TankWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class MIssble {
	private int x;
	private int y;
	private Direction dir; 
	private Boolean live = true;
	private Boolean good = true;
	public void setGood(Boolean good) {
		this.good = good;
	}
	public Boolean getLive() {
		return live;
	}
	private Yard tcc;
	public static final int SPEED = 10;
	public static final int WIDE= 10;
	public static final int HIGHT = 10;
	public MIssble(int x, int y,Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public MIssble(int x, int y,Boolean good, Direction dir, Yard tc) {
		this(x,y,dir);
		this.good=good;
		this.tcc = tc;
	}
	public void draw(Graphics g)
	{
		if(!live){
			tcc.MIssbles.remove(this);
			return;
		}
		Color c =g.getColor();
		if(good)	g.setColor(Color.blue);
		else        g.setColor(Color.darkGray);
		g.fillOval(x,y, WIDE,HIGHT);
		g.setColor(c);	
		remove();
	}
	private void remove() {
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
		if(x<0||y<0||x>Yard.YARD_WIDE||y>Yard.YRAD_HIGH)
		{
			live=false;
			
		}
		
	}
	public Rectangle getRect()
	{
		return new Rectangle(x,y,WIDE,HIGHT);
	}
	public boolean hitTank(Mytank t)
		{
		if(this.live&&this.getRect().intersects(t.getRect())&&t.getLive()&&this.good!=t.getGood())	
		{
			if(t.getGood())
			{
				this.live=false;
				t.setLife(t.getLife()-40);
				if(t.getLife()<=0)
				{
					t.setLive(false);
					
				}
			} 
			else
			{
				Explore e = new Explore(x,y,this.tcc);
				tcc.Explores.add(e);
				tcc.tanks.remove(t);
				t.setLive(false);
				this.live=false;
				return true;  
			}
		}
		return false;
	}
	public boolean hitTanks(List<Mytank> tanks){
		for(int i=0;i<tanks.size();i++)
		{
			if(hitTank(tanks.get(i)))
				return true;
		}
		return false;
		
	}
	public boolean hitWall(Wall w)
	{
		if(this.getRect().intersects(w.getRect())&&live)
		{
			live = false;
			return true;
		}
		return false;
	}

}
