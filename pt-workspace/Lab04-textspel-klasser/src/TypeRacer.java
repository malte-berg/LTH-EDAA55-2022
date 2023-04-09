import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TypeRacer {
	private List<String> phrases = new ArrayList<>();
	
	public TypeRacer() {
		addPhrases();
	}
	
	public String getPhrase() {
		Random r = new Random();
		return phrases.get(r.nextInt(15));
	}
	
	public void addPhrases() {
		phrases.add("Being unacquainted with the chief raccoon was harming his prospects for promotion.");
		phrases.add("The efficiency we have at removing trash has made creating trash more acceptable.");
		phrases.add("For the 216th time, he said he would quit drinking soda after this last Coke.");
		phrases.add("I only enjoy window shopping when the windows are transparent.");
		phrases.add("The fence was confused about whether it was supposed to keep things in or keep things out.");
		phrases.add("He waited for the stop sign to turn to a go sign.");
		phrases.add("I'm worried by the fact that my daughter looks to the local carpet seller as a role model.");
		phrases.add("They say that dogs are man's best friend, but this cat was setting out to sabotage that theory.");
		phrases.add("I was very proud of my nickname throughout high school but today- I couldn’t be any different to what my nickname was.");
		phrases.add("Even with the snow falling outside, she felt it appropriate to wear her bikini.");
		phrases.add("The bird had a belief that it was really a groundhog.");
		phrases.add("We need to rent a room for our party.");
		phrases.add("His get rich quick scheme was to grow a cactus farm.");
		phrases.add("The three-year-old girl ran down the beach as the kite flew behind her.");
		phrases.add("Jason lived his life by the motto: Anything worth doing is worth doing poorly.");
	}
}