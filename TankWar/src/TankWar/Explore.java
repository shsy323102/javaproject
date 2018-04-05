package TankWar;

import java.awt.Color;
import java.awt.Graphics;

public class Explore {
	public Explore(int x, int y, Yard tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	private	int x;
	private int y;
	private boolean live=true;
	private Yard tc;
	int i=0;
	int[] clrcle_R={3,7,15,30,50,40,11,5};
	public void draw(Graphics g)
	{
		if(!live) 
			{
				tc.Explores.remove(this);
				return;
			}
		if(i==clrcle_R.length)
		{
			live =false;
			i=0;
			return;
		}
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.drawOval(x,y, clrcle_R[i], clrcle_R[i]);	
		i++;
		g.setColor(c);
	}
	
}
