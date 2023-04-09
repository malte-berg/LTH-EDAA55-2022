import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> finished = new ArrayList<RaceTurtle>();
		RaceWindow rw = new RaceWindow();
		for (int i = 1; i <= 8; i++) {
			turtles.add(new RaceTurtle(rw, i));
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
