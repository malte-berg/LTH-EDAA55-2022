import java.util.Random;

public class DizzyTurtle extends RaceTurtle{
	
	private int dizzyness;
	private Random r = new Random();
	
	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		dizzyness = r.nextInt(5)+1;
	}
	
	@Override
	public void raceStep() {
		int turn = r.nextInt(dizzyness*2+1)-dizzyness;
		this.left(turn);
		super.raceStep();
	}
	
	@Override 
	public String toString() {
		return super.toString() + " - DizzyTurtle (Yrsel: " + dizzyness + ")";
	}
}
