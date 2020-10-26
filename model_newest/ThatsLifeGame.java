package game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This class serves as the brain of the game, where everything occurs.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class ThatsLifeGame {

	private Board board;
	private Deck actionCards;
	private Deck salaries; 
	private Deck careers;
	private Deck houses;
	private Deck blues; 
	private ArrayList<Player> players;
	private ArrayList<Card> cardsCareer;
	private int turn;
	private int place;
	
	/** 
	 * Creates the ThatLifeGame object, where the game takes place.
	 */
	public ThatsLifeGame(){
		
		board = new Board();
		actionCards = new ActionDeck();
		salaries = new SalaryDeck(); 
		careers = new CareerDeck();
		houses = new HouseDeck();
		blues = new BlueDeck();
		players = new ArrayList<>();
		place = 1;
		turn = 0;

		cardsCareer = new ArrayList<>();
		cardsCareer.add(new Career("Server", 1, 4, false));
		cardsCareer.add(new Career("Racecar Driver", 2, 8, false));
		cardsCareer.add(new Career("Athlete", 1, 6, false));
		Collections.shuffle(cardsCareer);
	}
	
	/** Adds a new player if the maximum number of players is not yet reached.
	 * @param name The name of the player.
	 */
	public void newPlayer(String name) {
		
		if(players.size() < 3)
			players.add(new Player(name));
	}

	/** The player goes to the college path.
	 * @param index The index of the player going to college.
	 */
	public void goToCollege(int index) {

		players.get(index).setPath(1);

		players.get(index).bankLoan();
		players.get(index).bankLoan();
	}
	
	/** The player goes to the career path.
	 * @param index The index of the player starting a career.
	 * @param careerChoice The number of the career card chosen by the player.
	 * @param salaryChoice The number of the salary card chosen by the player.
	 */
	public void gotoCareer(int index, int careerChoice, int salaryChoice) {

		int i;
		boolean key = false;

		while (cardsCareer.size() <= careerChoice){
			careerChoice = careerChoice - 1;
		}

		((CareerDeck) careers).remove(((Career) cardsCareer.get(careerChoice)).getTitle());
		players.get(index).setCareer(cardsCareer.get(careerChoice));
		cardsCareer.remove(careerChoice);
		players.get(index).setSalary(salaries.draw(salaryChoice));
	}

	/** Moves the player along the board, and does the action of the space that the player landed on.
	 * @param moves the number of steps the player does to complete the move
	 * @return the space that the player landed on.
	 */
	public Space move(int moves) {
		Space space = new Space("Retirement");
		
		if (!players.get(turn).getStatusRetirement()) {

			return space = board.move(players.get(turn), moves);
		}
		else {
			players.get(turn).setRank(place);
			place += 1;
		}

		return space;
	}

	/** Gets the index of the space the current player is on.
	 * 
	 * @return  the index of the space the current player is on.
	 */
	public int getCurrPlayerPos(){
		return players.get(turn).getPos();
	}
	
	/** Gets the index of the segment the current player is on.
	 * 
	 * @return  the index of the segmetn the current player is on.
	 */
	public int getCurrPlayerPath(){
		return players.get(turn).getPath();
	}

	/** Gets the money the current player has.
	 * 
	 * @return  the money the current player has.
	 */
	public double getCurrPlayerMoney() {
		return players.get(turn).getMoney();
	}
	
	/** Gets the house the current player owns.
	 * 
	 * @return  the house the current player owns.
	 */
	public String getCurrPlayerHouse(){
		return players.get(turn).getHouse().getName();
	}
	
	/** Shows the career of a player.
	 * @param index The index of the player 
	 * @return  the career of the chosen play in string format.
	 */
	public String showCareer(int index) {
		return ((CareerDeck) careers).show(index);
	}
	
	/** Shows the salary of a player.
	 * @param index The index of the player 
	 * @return  the salary of the chosen play in string format.
	 */
	public String showSalary(int index) {
		return ((SalaryDeck) salaries).show(index);
	}

	/** Shows if the career requires a degree or not.
	 * 
	 * @return the boolean value indicating if the degree is required or not.
	 */
	public boolean getBooleanCareer(){
		return ((Career) ((CareerDeck) careers).getCareers().get(0)).isDegRequired();
	}
	
	/** Gets a player.
	 * @param index The index of the player 
	 * @return  the player of the chosen index.
	 */
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	/** Gets all the players.
	 *
	 * @return the array list of players.
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	/** Gets the turn, the index of the current player.
	 *
	 * @return the the turn, the index of the current player.
	 */
	public int getTurn() {
		return turn;
	}
	
	/** Increments the turn, making the next player the current player.
	 *
	 */
	public void nextTurn(){
		turn += 1;
	}
	
	/** Resets the turn back to 0.
	 *
	 */
	public void resetTurn(){
		turn = 0;
	}

	/** Draws an action card from the action deck.
	 *
	 * @return the drawn action card.
	 */
	public Card drawActionCard(){
		Card card;

		return card = actionCards.draw(-1);
	}
	
	/** Executes the action indicated in the action card.
	 * @param attack the index of the targeted player of the current player.
	 * @param card The action card that the player has drawn
	 */
	public void orange(int attack, Card card) {

		if (((Action) card).getAction().equals("Lawsuit")) {
			((Action) card).doAction(players, turn, attack - 1);
		}
		else if (((Action) card).getAction().equals("File a Lawsuit")){
			((Action) card).doAction(players, turn, attack - 1);
		}
		else
			((Action) card).doAction(players, turn, -1);
	}

	/** Draws a blue card from the blue deck.
	 *
	 * @return the drawn blue card.
	 */
	public Card drawBlueCard(){
		Card card;
		return card = blues.draw(-1);
	}

	/** Executes the action indicated in the blue card.
	 * @param card The blue card that the player has drawn
	 */
	public void blue(Card card) {
		((Blue) card).doAction(players, turn);
	}
	
	/** Executes an action when a player lands on magenta space.
	 * @param index The indicator on which actiion to execute
	 * @param choice The choice chosen by the player
	 */
	public void magenta(int index, int choice) {
		
		int i;
		
		if (index == 1) {

			players.get(turn).setCareer(careers.draw((choice/10)));
			players.get(turn).setSalary(salaries.draw((choice%10)));
			
			((SalaryDeck) salaries).addTop();
			players.get(turn).setDegree(true);
		}
		else if (index == 2) {

			if (choice == 1) {
				Card newCareer = careers.draw(choice);
				Card newSalary = salaries.draw(choice);

				players.get(turn).setCareer(newCareer);
				players.get(turn).setSalary(newSalary);
			}
		}
		else if (index == 3) {
			
			House chosenHouse = ((House) ((HouseDeck) houses).draw(choice));
			
			players.get(turn).setHouse(chosenHouse);
			players.get(turn).addCash(-chosenHouse.getValue());
			
			while (players.get(turn).getMoney() < 0) {
				players.get(turn).bankLoan();
			}
		}
		else if (index == 4) {	//MARRY
			
			double toPay;
			
			players.get(turn).marry();
			
			if (randomize(2) == 0)
				toPay = 10000;
			else
				toPay = 5000;
			
			for(i = 0; i < players.size(); i++) {
				
				if (i != turn) {
					players.get(i).addCash(-toPay);
					players.get(turn).addCash(toPay);
				}
			}
			
		}
		else if (index == 5) {		//HAVE CHILDREN
		
			if(randomize(6) == 5)
				players.get(turn).addChildren(2);
			else
				players.get(turn).addChildren(1);
			
			for(i = 0; i < players.size(); i++) {
				
				if (i != turn) {
					players.get(i).addCash(-(players.get(turn).getChildren() * 5000));
					players.get(turn).addCash(players.get(turn).getChildren() * 5000);
				}
			}
		}	
		else if (index == 6 || index == 7) {
			
			if (choice == 2) {
				players.get(turn).setPath(players.get(turn).getPath() + 2);
				players.get(turn).setPos(-1);
			}
			
		}
	}
	
	/** Executes an action when a player lands on magenta space.
	 * @param index The indicator on which actiion to execute
	 */
	public void green(int index) {
		
		double[] raise = {10000, 10000, 10000, 20000, 20000, 30000};
		Random luckyMoney = new Random();
		
		if (index == 1) {
			players.get(turn).addCash((players.get(turn).getSalaryCard().getSalary()));
		}
		else if (index == 2) {
			
			if (players.get(turn).getCareerCard().getPayRaise() > 0) {
				players.get(turn).getSalaryCard().addSalary(raise[luckyMoney.nextInt(6)]);
				players.get(turn).getCareerCard().minusPayRaise(); // i--
			}
				
			players.get(turn).addCash((players.get(turn).getSalaryCard().getSalary()));
		}
	}
	
	/** Calculates and determines the winner if all the players have finished
	 * 
	 * @return the index of the winner and -1 if the game is not finished.
	 */
	public int gameOver() {
		
		int i;
		boolean key = true;
		
		for (i = 0; i < players.size() && key; i++) {
			key = players.get(i).getStatusRetirement();
		}

		if (key) {
			
			for (i = 0; i < players.size(); i++) {
				if (players.get(i).getRank() == 1)
					players.get(i).addFinalMoney(100000);
				else if (players.get(i).getRank() == 2)
					players.get(i).addFinalMoney(50000);
				else if (players.get(i).getRank() == 3)
					players.get(i).addFinalMoney(20000);
			}
			
			for (i = 0; i < players.size(); i++) {
				players.get(i).addFinalMoney(players.get(i).getChildren() * 10000); //children
				players.get(i).addFinalMoney(players.get(i).getHouse().getValue()); //house
				players.get(i).addFinalMoney(players.get(i).getMoney()); //money
				players.get(i).addFinalMoney(-players.get(i).getLoan()); //loan
			}

			players.get(0).setRank(1);
			players.get(1).setRank(2);
			int winner = 0;
			int second = 1;

			if (players.get(0).getFinalMoney() < players.get(1).getFinalMoney()) {
				players.get(1).setRank(1);
				players.get(0).setRank(2);
				winner = 1;
				second = 0;
			}

			if (players.size() == 3) {

				if (players.get(2).getFinalMoney() > players.get(winner).getFinalMoney()){
					players.get(2).setRank(1);
					players.get(winner).setRank(2);
					players.get(second).setRank(3);
				}
				else if (players.get(2).getFinalMoney() > players.get(second).getFinalMoney()) {

					players.get(winner).setRank(1);
					players.get(2).setRank(2);
					players.get(second).setRank(3);
				}
				else {
					players.get(2).setRank(3);
				}
			}

			return winner + 1;
		}
		else 
			return -1;
	}

	/** Checks the number of players if there are enough players to start the game (true if it is enough; otherwise, not).
	 *
	 * @return the boolean value indicating if there is enough players or not.
	 */
	public boolean hasEnoughPlayers() {
		return players.size() > 1 && players.size() < 4;
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

