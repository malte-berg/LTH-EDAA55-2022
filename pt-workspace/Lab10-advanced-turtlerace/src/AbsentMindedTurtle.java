import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle{
	private int absence;
	private Random r = new Random();
	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		absence = r.nextInt(100);
	}
	
	@Override
	public void raceStep() {
		if (r.nextInt(100) > absence) {
			super.raceStep();
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " - AbsentMindedTurtle (" + absence + "% frånvarande)";
	}
}
