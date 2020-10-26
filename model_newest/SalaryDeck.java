package game.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class serves as the Houses that can be purchased.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class SalaryDeck extends Deck{

	/** 
	 * Creates a player object, creates a player that moves on the board.
	 */
	public SalaryDeck() {	
		
		cards = new ArrayList<Card>();
		
		for (int i = 1; i <= 50; i++)
			cards.add(new Salary());
		
		top = 0;
		
		Collections.shuffle(cards);
	}
	
	/** Gets the salaries.
	 *
	 * @return the array list of the Salary cards
	 */
	public ArrayList<Card> getSalaries(){
		return cards;
	}
	
	/** moves the top of the deck down by 1.
	 * 
	 */
	public void addTop() {
		top += 1;
	}
	
	/** Gets the salary of the chosen index in the deck.
	 * @param index The index of the chosen card.
	 * @return the chosen salary in string format.
	 */
	public String show(int index) {

		String salary = Double.toString(((Salary) cards.get(index)).getSalary());
				return salary;
	}
}
