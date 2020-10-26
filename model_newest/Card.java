package game.model;

/**
 * This class serves as the superclass of all the cards in the game.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Card {
	
	private String cardName;
	
	/** 
	 * Creates a Card object.
	 */
	public Card() {
		
	}
	
	/** Gets the name of the card.
	 *
	 * @return the name of the card.
	 */
	public String getCardName() {
		return cardName;
	}
}