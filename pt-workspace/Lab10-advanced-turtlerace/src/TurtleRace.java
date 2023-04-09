import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finished = new ArrayList<RaceTurtle>();
		RaceWindow rw = new RaceWindow();
		Random r = new Random();
		for (int i = 1; i <= 8; i++) {
			int type = r.nextInt(3);
			if (type == 0) {
				turtles.add(new MoleTurtle(rw, i));
			} else if (type == 1) {
				turtles.add(new DizzyTurtle(rw, i));
			} else if (type == 2) {
				turtles.add(new AbsentMindedTurtle(rw, i));
			}
		}
		
		for (RaceTurtle t : turtles)  {
			System.out.println(t);
		}
		
		while (turtles.size() > 0) {
			for (int i = 0; i < turtles.size(); i++) {
				turtles.get(i).raceStep();
				if(turtles.get(i).getX() >= RaceWindow.X_END_POS) {
					finished.add(turtles.get(i));
					turtles.remove(i);
					i--;
				}
			}
			RaceWindow.delay(10);
		}
		
		for(int i = 0; i < 3; i++) {
			String s = "På plats " + (i+1) + ": ";
			s += finished.get(i).toString();
			System.out.println(s);
		}
	}
}
