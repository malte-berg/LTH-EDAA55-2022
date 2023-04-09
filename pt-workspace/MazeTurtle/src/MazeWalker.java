import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle turtle;
	private int turns = 0, steps = 0;
	
	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}
	
	public void walk (Maze maze) {
		turtle.penDown();
		
		//Medan sköldpadda inte är vid utgång
		while (!maze.atExit(turtle.getX(),turtle.getY())) {
			
			//Om det inte är någon vägg till vänster, sväng vänster
			if (!maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				turtle.left(90);
				turns++;
				
			//Om det är en vägg framför, sväng höger
			} else if (maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY())) {
				turtle.left(-90);
				turns++;
			}
			
			turtle.forward(1);
			steps++;
			SimpleWindow.delay(1);
		}
		turtle.penUp();
		
		//Skriv ut statistik
		System.out.println("Steg: " + steps + "\nRiktningsändringar: " + turns);
		
	}

}
