package memory;
import javax.swing.JOptionPane;
import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		int size = 4;
		MemoryBoard board = new MemoryBoard(size, "back.jpg", frontFileNames);
		MemoryWindow window = new MemoryWindow(board);
		
		window.drawBoard();
		
		boolean play = true;
		int attempts = 0;
		
		while (play) {
			attempts = startGame(board, window, size);
			int option = JOptionPane.showConfirmDialog(null, "Du vann! Det tog " + attempts + " försök.\nVill du försöka igen?", "Memory", JOptionPane.YES_NO_OPTION);
			//Om ja, börja om, annars avsluta
			if (option == 0) {
				board.restart();
				window.drawBoard();
				continue;
			} else play = false;
		}
		System.exit(0);
	}
	
	private static int startGame(MemoryBoard board, MemoryWindow window, int size) {
		int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
		int attempts = 0;
		while (!board.hasWon()) {
			window.waitForMouseClick();
			r1 = window.getMouseRow();
			c1 = window.getMouseCol();
			
			//Om tryckta kortet är uppvänt, gå tillbaka till början och vänta på 
			if(board.frontUp(r1, c1)) {
				continue;
			} else {
				board.turnCard(r1, c1);
				window.drawBoard();
				
				//Kod för att kolla om kortet som tryckts på är giltigt (ej uppvänt)
				boolean validCard = false;
				while (!validCard) {
					window.waitForMouseClick();
					r2 = window.getMouseRow();
					c2 = window.getMouseCol();
					
					//Ifall klickade kortet är uppvänt, gå tillbaka och invänta nytt korrekt klickat kort
					if(board.frontUp(r2, c2)) continue;
					else validCard = true;
				}
				
				board.turnCard(r2, c2);
				window.drawBoard();
			}
			
			//Om kort ej är samma, vänd tillbaka dem, annars behåll korten uppvända
			if (!board.same(r1, c1, r2, c2)) {
				SimpleWindow.delay(750);
				board.turnCard(r1, c1);
				board.turnCard(r2, c2);
				window.drawBoard();
			} 
			attempts++;
		}
		return attempts;
	}
}
