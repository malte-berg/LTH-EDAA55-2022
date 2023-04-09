import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	private double xPos, yPos;
	private SimpleWindow w;
	private boolean isPenDown;
	private int direction;
	private Color color;
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		w.moveTo(x, y);
		this.xPos = x;
		this.yPos = y;
		this.w = w;
		this.direction = 90;
		this.isPenDown = false;
		this.color = Color.BLACK;
	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.setLineColor(color);
		w.moveTo((int) xPos, (int) yPos);
		xPos += (n * Math.cos(direction*(Math.PI/180)));
		yPos -= (n * Math.sin(direction*(Math.PI/180)));
		if (isPenDown) {
			w.lineTo((int) Math.round(xPos), (int) Math.round(yPos));
		} else {
			w.moveTo((int) Math.round(xPos), (int) Math.round(yPos));
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		direction += beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		xPos = newX;
		yPos = newY;
		w.moveTo((int) xPos, (int) yPos);
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		direction = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(xPos);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(yPos);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return direction;
	}
 	
 	public void changeColor(Color c) {
 		color = c;
 	}
}
