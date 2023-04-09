public class Mole {

	Graphics g = new Graphics(30, 50, 10);
	
	int skyHeight = 8;

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
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
			if (x < 0) {
				x = 0;
			} else if (x > g.getWidth()) {
				x = g.getWidth();
			} else if (y < skyHeight - 1) {				// Om mullvaden får för sig att flyga
				g.block(x, y, Colors.SKY);  			// Rita himmel
				y = skyHeight - 1;						// Ta ner mullvaden till marken igen
			} else if (y > g.getHeight()) {
				y = g.getHeight();
			}
			
			g.block(x, y, Colors.MOLE);
			
			// Vänta på knapptryck
			char key = g.waitForKey();
			
			// Om mullvaden är på eller under gräset
			if (y > skyHeight - 1) {
				g.block(x, y, Colors.TUNNEL);
			} else {
				g.block(x, y, Colors.SKY);
			}
			
			if (key == 'w') {
				y--;
				g.block(x, y, Colors.MOLE);
			} else if (key == 'a') {
				x--;
				g.block(x, y, Colors.MOLE);
			} else if (key == 's') {
				y++;
				g.block(x, y, Colors.MOLE);
			} else if (key == 'd') {
				x++;
				g.block(x, y, Colors.MOLE);
			}
		}
	}
}
