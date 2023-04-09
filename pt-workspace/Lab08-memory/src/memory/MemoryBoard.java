package memory;

import java.util.Random;

public class MemoryBoard {
	
	private MemoryCardImage[][] cards;
	private int size;
	private boolean[][] turned;
	private String backFileName;
	private String[] frontFileNames;

	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		cards = new MemoryCardImage[size][size];
		turned = new boolean[size][size];
		this.backFileName = backFileName;
		this.frontFileNames = frontFileNames;
		createCards(backFileName, frontFileNames);
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		int noOfPairs = size * size / 2;
		for (int i = 0; i < noOfPairs; i++) {
			MemoryCardImage currentCard = new MemoryCardImage(frontFileNames[i], backFileName);
			Random r = new Random();
			int row = r.nextInt(size);
			int col = r.nextInt(size);
			for (int j = 0; j < 2; j++) {
				while (cards[row][col] != null) {
					row = r.nextInt(size);
					col = r.nextInt(size);
				}
				cards[row][col] = currentCard;
			}
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return cards[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if(turned[r][c]) {
			turned[r][c] = false;
		} else {
			turned[r][c] = true;
		}
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return turned[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return cards[r1][c1] == cards[r2][c2];
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!frontUp(i, j)) {
					return false;
				}
			}
		}
		return true;
	}	
	
	//Återställ planen genom att sätta turned och cards till false resp. null
	public void restart() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				turned[i][j] = false;
				cards[i][j] = null;
			}
		}
		createCards(backFileName, frontFileNames);
	}
}
