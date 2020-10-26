package game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class serves as a Deck of Blue cards.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class BlueDeck extends Deck{

	private double fixedAmt;
	
	/** 
	 * Creates a BlueDeck object, creates a deck which which consists of Blue cards.
	 */
	BlueDeck() {
		
		int i;
		top = 0;
		cards = new ArrayList<Card>();
			
		String[] Careers = {"Lawyer", "Computer Consultant", "Racecar Driver", "Doctor", "Accountant", "Server", "Athlete"};
		
		fixedAmt = (randomize(11) + 5) * 10000;
		
		for (i = 1; i <= 50 ;i++)
			cards.add(new Blue(Careers[randomize(5)], fixedAmt));
		
		Collections.shuffle(cards);
	}
	
	/** Generates a random number from 0 to a certain limit.
	 * @param limit the maximum value it can generate.
	 * @return the generated number.
	 */
	private int randomize(int limit) {
		Random numGenerator = new Random();
		return numGenerator.nextInt(limit);
	}
}
