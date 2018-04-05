package TankWar;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {
public Wall(int x, int y, int w, int h, Yard tc) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	private int x;
	private int y;
	private int w;
	private int h;
	private Yard tc;
	public void draw(Graphics g)
	{
		g.fillRect(x, y, w, h);
	}
	public Rectangle getRect()
	{
		return new Rectangle(x,y,w,h);
	}
}
