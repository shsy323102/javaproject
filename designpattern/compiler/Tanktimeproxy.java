package dp.proxy;
import java.util.Date;
public class Tanktimeproxy implements dp.proxy.Moveable{
     Moveable t;
     public Tanktimeproxy(Moveable t) {
     this.t = t;}
   public void move() {
    System.out.println("start:"+new Date(System.currentTimeMillis()));
    t.move();
    System.out.println("stop:"+new Date(System.currentTimeMillis()));
}
}