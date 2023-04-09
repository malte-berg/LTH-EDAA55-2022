import java.util.Random;
import java.util.Scanner;

public class Game {
	private String cpuChoice, userChoice;
	private int cpuScore = 0, userScore = 0;

	public void play () {
		rules();
		while(true) {
			makeTurn();
			if (userScore == 3 || cpuScore == 3) break;
		}
		System.out.printf("Final score: CPU %d - %d User\n\n", cpuScore, userScore);
		if(userScore == 3) {
			System.out.println("User wins!");
		} else {
			System.out.println("CPU wins!");
		}
	}
	
	public void makeTurn() {
		cpuTurn();
		userTurn();
		System.out.printf("\nYou chose %s, CPU chose %s.\n", getUserChoice(), getCpuChoice());
		compareChoices();
		System.out.printf("New score: CPU %d - %d User\n\n", cpuScore, userScore);
	}
	
	public void compareChoices() {
		switch(userChoice) {
		case "rock": 
			if (cpuChoice.equals(userChoice)) {
				System.out.println("Draw! No points awarded.");
			} else if (cpuChoice.equals("scissors") || cpuChoice.equals("lizard")) {
				userScore++;
				System.out.println("User gains a point.");
			} else {
				cpuScore++;
				System.out.println("CPU gains a point.");
			}
			break;
		case "paper": 
			if (cpuChoice.equals(userChoice)) {
				System.out.println("Draw! No points awarded.");
			} else if (cpuChoice.equals("rock") || cpuChoice.equals("spock")) {
				userScore++;
				System.out.println("User gains a point.");
			} else {
				cpuScore++;
				System.out.println("CPU gains a point.");
			}
			break;
		case "scissors": 
			if (cpuChoice.equals(userChoice)) {
				System.out.println("Draw! No points awarded.");
			} else if (cpuChoice.equals("paper") || cpuChoice.equals("lizard")) {
				userScore++;
				System.out.println("User gains a point.");
			} else {
				cpuScore++;
				System.out.println("CPU gains a point.");
			}
			break;
		case "lizard": 
			if (cpuChoice.equals(userChoice)) {
				System.out.println("Draw! No points awarded.");
			} else if (cpuChoice.equals("spock") || cpuChoice.equals("paper")) {
				userScore++;
				System.out.println("User gains a point.");
			} else {
				cpuScore++;
				System.out.println("CPU gains a point.");
			}
			break;
		case "spock": 
			if (cpuChoice.equals(userChoice)) {
				System.out.println("Draw! No points awarded.");
			} else if (cpuChoice.equals("scissors") || cpuChoice.equals("rock")) {
				userScore++;
				System.out.println("User gains a point.");
			} else {
				cpuScore++;
				System.out.println("CPU gains a point.");
			}
			break;
		}
	}
	
	public void rules() {
		System.out.println("Welcome to Rock Paper Scissors Lizard Spock!");
		System.out.println("Rules:");
		System.out.println("- Rock takes scissors and lizard");
		System.out.println("- Paper takes rock and spock");
		System.out.println("- Scissors takes paper and lizard");
		System.out.println("- Lizard takes spock and paper");
		System.out.println("- Spock takes rock and scissors");
		System.out.println("First one to 3 points wins!\n");
	}
	
	public String getCpuChoice() {
		return cpuChoice;
	}

	public String getUserChoice() {
		return userChoice;
	}

	public void cpuTurn() {
		makeCpuChoice();
		System.out.println("CPU has made its choice.");
	}

	public void userTurn() {
		System.out.println("Make your choice.");
		Scanner sc = new Scanner(System.in);
		String input = sc.next().toLowerCase();
		switch (input) {
		case "rock":
			userChoice = "rock";
			break;
		case "paper":
			userChoice = "paper";
			break;
		case "scissors":
			userChoice = "scissors";
			break;
		case "lizard":
			userChoice = "lizard";
			break;
		case "spock":
			userChoice = "spock";
			break;
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
