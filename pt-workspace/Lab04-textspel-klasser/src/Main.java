import java.util.Scanner;
import se.lth.cs.pt.timer.Timer;

public class Main {

	TypeRacer tr = new TypeRacer();
	Scanner sc = new Scanner(System.in);

	boolean play = true;

	public static void main(String[] args) {
		Main m = new Main();
		while (m.play) {
			m.start();
		}
	}

	public void start() {
		String ans = "";
		String typedPhrase = "";
		String phrase = tr.getPhrase();
		System.out.println("Redo? (j/n)");
		ans = sc.next();
		if(ans.equals("j")) {
			System.out.println("Din fras är:\n" + phrase);
		} else if (ans.equals("n")) {
			play = false;
			return;
		}
		Timer.delay(2000);
		System.out.println("3...");
		Timer.delay(1000);
		System.out.println("2...");
		Timer.delay(1000);
		System.out.println("1...");
		Timer.delay(1000);
		System.out.println("Skriv!");
		long startTime = System.currentTimeMillis();
		typedPhrase = sc.next();
		long endTime = System.currentTimeMillis();
		long elapsed = endTime-startTime;
		double seconds = Double.longBitsToDouble(elapsed)/1000;
		int noOfWords = phrase.split(" ").length;
		System.out.println(noOfWords);
		double wpm = ((double) noOfWords)/(seconds/60);
		if (typedPhrase.equals(phrase)) {
			System.out.printf("Du skrev frasen rätt på %d sekunder. Du skrev frasen med en hastighet av %d ord per minut", seconds);
		}
	}
}
