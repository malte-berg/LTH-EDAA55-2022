import java.awt.Color;
import se.lth.cs.pt.window.SimpleWindow;

public class Graphics {
	private int width;
	private int blockSize;
	private int height;

	private SimpleWindow w;

	public Graphics(int w, int h, int bs) {
		this.width = w;
		this.height = h;
		this.blockSize = bs;
		this.w = new SimpleWindow(width * blockSize, height * blockSize, "Digging");
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void block(int x, int y, Color color) {
		w.setLineColor(color);
		int left = x * blockSize;
		int right = left + blockSize - 1;
		int top = y * blockSize;
		int bottom = top + blockSize - 1;
		for (int row = top; row <= bottom; row++) {
			w.moveTo(left, row);
			w.lineTo(right, row);
		}
	}

	public void rectangle(int x, int y, int width, int height, Color c) {
		for (int yy = y; yy < y + height; yy++) {
			for (int xx = x; xx < x + width; xx++) {
				block(xx, yy, c);
			}
		}
	}

	public char getKey() {
		return w.getKey();
	}

	public int waitForEvent() {
		w.waitForEvent();
		return w.getEventType();
	}
}
