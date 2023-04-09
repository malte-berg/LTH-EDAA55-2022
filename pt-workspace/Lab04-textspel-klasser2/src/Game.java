import java.util.Random;
import java.util.Scanner;

public class Game {
	private String cpuChoice, userChoice;
	private static int cpuScore = 0, userScore = 0;

	public Game() {
		
	}
	
	public String getCpuChoice() {
		return cpuChoice;
	}
	public String getUserChoice() {
		return userChoice;
	}
	
	public String cpuTurn() {
		makeCpuChoice();
		return getCpuChoice();
	}
	
	public void makeUserChoice() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next().toLowerCase();
		switch(input) {
		case "rock": userChoice = "rock"; break;
		case "paper": userChoice = "paper"; break;
		case "scissors": userChoice = "scissors"; break;
		case "lizard": userChoice = "lizard"; break;
		case "spock": userChoice = "spock"; break;
		
		}
	}
	public void makeCpuChoice() {
		Random r = new Random();
		int choice = r.nextInt(5);
		switch (choice) {
			case 0:
				cpuChoice = "rock";
				break;
			case 1:
				cpuChoice = "paper";
				break;
			case 2:
				cpuChoice = "scissors";
				break;
			case 3:
				cpuChoice = "lizard";
				break;
			case 4:
				cpuChoice = "spock";
				break;
		}
	}
}
