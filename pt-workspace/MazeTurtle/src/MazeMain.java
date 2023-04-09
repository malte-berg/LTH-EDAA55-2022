import se.lth.cs.pt.window.SimpleWindow;
import java.util.Scanner;
import se.lth.cs.pt.maze.Maze;

public class MazeMain {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "Maze");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		Maze m = new Maze(x);
		Turtle t = new Turtle(w, m.getXEntry(), m.getYEntry());
		MazeWalker mt = new MazeWalker(t);
		
		m.draw(w);
		mt.walk(m);
	}

}
