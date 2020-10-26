package game.model;

import java.util.ArrayList;

/**
 * This class serves as a Deck of House cards.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class HouseDeck extends Deck{
	
	/** 
	 * Creates a HouseDeck object, creates a deck which consists of House Cards.
	 */
	public HouseDeck() {
		
		cards = new ArrayList<Card>();
				
		//TO BE ACCOMPLISHED
		cards.add(new House("Torre 2, Room 712", 80000, 8000));
		cards.add(new House("Tagaytay Vacation House", 180000, 18000));
		cards.add(new House("Fishing Ywah Hotel, Penthouse", 120000, 12000));
		cards.add(new House("Camella Homes, Two-storey House", 100000, 10000));
		cards.add(new House("Baguio Bungalow", 75000, 7500));
		cards.add(new House("Chan Ancestral Dragon Homes, Four-storey House", 250000, 50000));
		cards.add(new House("Ona Teriyaki Treehouse", 50000, 1000));
		cards.add(new House("Zojo Motel Shhh", 10000, 1000));
		cards.add(new House("Shirley Residences, One-storey House pero super wide", 150000, 15000));
		
		top = 0;
	}
	
	/** Gets the house that was chosen then removes it from the deck, an override function.
	 * @param choice The number of the card chosen by the player.
	 * @return the chosen house
	 */
	@Override
	public Card draw(int choice) {
		
		Card card = cards.get(choice - 1);
		cards.remove(choice - 1);
		
		return card;
	}
	
	/** Gets the houses that are still available.
	 * @param
	 * @return the list of houses.
	 */
	public ArrayList<Card> getHouses(){
		return cards;
	}
}
