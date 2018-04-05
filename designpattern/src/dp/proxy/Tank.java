package dp.proxy;

import java.util.Random;

public class Tank implements Movable{
	public void move(){
		System.out.println("move ...");
		try {
			Thread.sleep(new Random().nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
