package game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class serves as a Deck of Action cards.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class ActionDeck extends Deck{
	
	/** 
	 * Creates an ActionDeck object, creates a deck which consists of Action Cards.
	 */
	ActionDeck() {
		
		int i;
		top = 0;
		cards = new ArrayList<Card>();
				
		String[] CFTB = {"Tax refund", "Sell an item", "Bonus Payday", "Setup school", "Write a book"};
		String[] PTB = {"Buy an item", "Visit a place", "Hiking", "Watch a show", "Win a competition", "Traffic violation"};
		String[] PTP = {"Lawsuit", "Christmas Bonus"};
		String[] CFP = {"File a lawsuit", "It is your Birthday"};
			
		Double[] amounts = {(double) 10000, (double) 20000};
		
		for (i = 1; i <= 50 ; i++) {
			if (i <= 20)
				cards.add(new Action("Collect From The Bank", CFTB[randomize(5)], amounts[randomize(2)]));
			else if (i <= 40)
				cards.add(new Action("Pay The Bank", PTB[randomize(6)], amounts[randomize(2)]));
			else if (i <= 45)
				cards.add(new Action("Pay The Player", PTP[randomize(2)], amounts[randomize(2)]));
			else
				cards.add(new Action("Collect From Player", CFP[randomize(2)], amounts[randomize(2)]));
		}
		
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

