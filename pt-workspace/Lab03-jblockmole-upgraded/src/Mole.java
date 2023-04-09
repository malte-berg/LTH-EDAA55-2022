import javax.swing.*;
import se.lth.cs.pt.window.SimpleWindow;

public class Mole {

	Graphics g = new Graphics(30, 50, 10);

	int skyHeight = Integer.parseInt(JOptionPane.showInputDialog("Sky Height"));

	public static void main(String[] args) {
		Mole m = new Mole();
		while (true) {
			m.drawWorld();
			m.dig();
		}
	}

	public void drawWorld() {
		g.rectangle(0, 0, g.getWidth(), skyHeight, Colors.SKY);
		g.rectangle(0, skyHeight, g.getWidth(), 1, Colors.GRASS);
		g.rectangle(0, skyHeight + 1, g.getWidth(), g.getHeight() - (skyHeight + 1), Colors.SOIL);
	}

	public void dig() {
		int x = g.getWidth() / 2;
		int y = skyHeight - 1;
		while (true) {
			//Kantcheck
			if (x < 0) {
				x = 0;
			} else if (x >= g.getWidth()) {
				x = g.getWidth()-1;
			} else if (y < skyHeight - 1) { // Om mullvaden får för sig att flyga
				g.block(x, y, Colors.SKY); 	// Rita himmel
				y = skyHeight - 1; 			// Ta ner mullvaden till marken igen
			} else if (y >= g.getHeight()) {
				y = g.getHeight()-1;		//Låt inte mullvad gräva under fönstret
			}

			g.block(x, y, Colors.MOLE);

			// Vänta på knapptryck
			int eventType = g.waitForEvent();

			if (eventType == SimpleWindow.MOUSE_EVENT) {
				return;
			} else {
				char key = g.getKey();

				// Om mullvaden är på eller under gräset
				if (y > skyHeight - 1) {
					g.block(x, y, Colors.TUNNEL);
				} else {
					g.block(x, y, Colors.SKY);
				}

				switch (key) {
				case 'w' -> y--;
				case 'a' -> x--;
				case 's' -> y++;
				case 'd' -> x++;
				}
				g.block(x, y, Colors.MOLE);
			}
		}
	}
}
