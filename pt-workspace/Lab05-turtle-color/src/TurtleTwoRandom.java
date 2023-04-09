import java.awt.Color;
import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class TurtleTwoRandom {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleTwoRandom");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		t1.penDown();
		t2.penDown();
		t1.changeColor(Color.BLUE);
		t2.changeColor(Color.RED);
		Random r = new Random();
		double turtleDistance = Math.hypot(t1.getX()-t2.getX(), t1.getY()-t2.getY());
		while(turtleDistance >= 50) {
			t1.forward(r.nextInt(10)+1);
			t1.left(r.nextInt(361)-180);
			t2.forward(r.nextInt(10)+1);
			t2.left(r.nextInt(361)-180);
			turtleDistance = Math.hypot(t1.getX()-t2.getX(), t1.getY()-t2.getY());
			SimpleWindow.delay(10);
		}
	}

}
