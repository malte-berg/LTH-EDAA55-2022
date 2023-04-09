import java.util.Random;

public class MoleTurtle extends RaceTurtle{
	
	private Random r = new Random();
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	@Override
	public void raceStep() {
		if (r.nextInt(10) > 5) {
			this.penUp();
		} else {
			this.penDown();
		}
		super.raceStep();
	}
	
	@Override
	public String toString() {
		return super.toString() + " - MoleTurtle";
	}
}
