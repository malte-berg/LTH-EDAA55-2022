import java.util.Random;

public class RaceTurtle extends Turtle {
	
	private int startPos;
	private Random r = new Random();

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		startPos = nbr;
		this.left(-90);
		this.penDown();
	}
	
	public void raceStep() {
		this.forward(r.nextInt(5)+1);
	}
	
	public String toString() {
		return "Nummer " + startPos;
	}

}
