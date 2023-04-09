import se.lth.cs.pt.window.SimpleWindow;

import java.awt.Color;

public class SimpleWindowExample {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "Drawing Window");

		w.moveTo(100, 100);
		w.delay(500);
		w.lineTo(150, 100);
		w.delay(500);
		w.moveTo(200, 200);
		w.setLineWidth(20);
		w.setLineColor(Color.RED);
		w.lineTo(300, 250);
		w.moveTo(200, 250);
		w.setLineColor(Color.BLUE);
		w.delay(500);
		w.lineTo(300, 200);
		w.moveTo(200, 350);
		w.setLineColor(Color.GREEN.darker());
		w.delay(500);
		w.writeText("Hello World!");
	}
}
