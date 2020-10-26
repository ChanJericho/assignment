package game.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class serves as the superclass of all the decks in the game, an abstract class.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public abstract class Deck {

	protected ArrayList<Card> cards;
	protected int top;
	
	/** Gets the array list of cards.
	 * @return the array list of cards.
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	/** Gets the top card on the deck or the card a number down from the top.
	 * @param choice The number of card from the top or an indicator of a regular draw.
	 * @return the drawn card.
	 */
	public Card draw(int choice) {
		
		Card card;
		
		if (top == 50) {
			top = 0;
			Collections.shuffle(cards);	
		}
		
		if (choice == -1) {
			card = cards.get(top);
			top += 1;
		}
		else {
			card = cards.get(choice - 1);
			top += 1;
		}
		
		return card;
	}
	
	/** Gets the index where the top card is.
	 *
	 * @return the index where the top card is.
	 */
	public int getTop() {
		return top;
	}
}

