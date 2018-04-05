import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Food {
	Random r = new Random();
	private int x=r.nextInt(Yard.WIDE-5);
	private int y=r.nextInt(Yard.HIGHT-5);
	private int SIZE=Yard.SIZE;	
	public void draw(Graphics g)
	{   
		Color c =g.getColor();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillOval(x*SIZE, y*SIZE, SIZE, SIZE);
		g.setColor(c);
	}
	public Rectangle getRect()
	{
		return new Rectangle(x*SIZE,y*SIZE,SIZE,SIZE);
	}
	public void reApprear()
	{
		this.x=r.nextInt(Yard.WIDE-5);
		this.y=r.nextInt(Yard.HIGHT-5);
	}
}
