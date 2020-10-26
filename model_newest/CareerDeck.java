package game.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class serves as the Deck of Career cards.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class CareerDeck extends Deck{

	/** 
	 * Creates a CareerDeck object, creates a deck which consists of career cards.
	 */
	public CareerDeck() {
		
		cards = new ArrayList<Card>();
		
		cards.add(new Career("Lawyer", 5, 8, true));
		cards.add(new Career("Accountant", 4, 7, true));
		cards.add(new Career("Computer Consultant", 3, 7, true));
		cards.add(new Career("Doctor", 5, 8, true));
		cards.add(new Career("Server", 1, 4, false));
		cards.add(new Career("Racecar Driver", 2, 8, false));
		cards.add(new Career("Athlete", 1, 6, false));

		top = 0;
		
		Collections.shuffle(cards);
	}
	
	/** Gets the array list of careers.
	 * 
	 * @return the array list of careers.
	 */
	public ArrayList<Card> getCareers(){
		return cards;
	}
	
	/** Gets the career that was chosen then removes it from the deck, an override function.
	 * @param choice The number of the card chosen by the player.
	 * @return the chosen career
	 */
	@Override
	public Card draw(int choice) {
		
		Card card = cards.get(choice - 1);
		cards.remove(choice - 1);
		Collections.shuffle(cards);
		
		return card;
	}
	
	/** Gets the career of the chosen index in the deck.
	 * @param index The index of the chosen card.
	 * @return the chosen career in string format.
	 */
	public String show(int index) {
		return ((Career) cards.get(index)).getTitle();
	}

	/** Removes a specific career in the deck.
	 * @param target The title of the career to be removed.
	 */
	public void remove(String target) {
		int i;

		for (i = 0; i < cards.size(); i++) {
			if (target.equalsIgnoreCase(((Career) cards.get(i)).getTitle())){
				cards.remove(i);
			}
		}
	}
}
