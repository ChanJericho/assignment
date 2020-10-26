package game.model;

import java.util.ArrayList;

/**
 * This class serves as Actions card which indicates the actions that will be done.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Action extends Card{

	private String name;
	private String action;
	private double amount; 
	
	/** 
	 * Creates an Action object, creates an action card of which the players of the game will perform.
	 * @param name The group where the action belongs
	 * @param action The action that will be performed
	 * @param amount The amount of money to be paid or recieved.
	 */
	Action(String name, String action, double amount){
		
		this.name = name;
		this.action = action;
		this.amount = amount;
	}
	
	/** gets the name of the Action card.
	 * 
	 * @return the name of the Action card.
	 */
	public String getName() {
		return name;
	}
	
	/** gets the name of the action that will be performed.
	 * 
	 * @return the name of the action that will be performed.
	 */
	public String getAction() {
		return action;
	}
	
	/** gets the amount to pe paid or recieved.
	 * @param
	 * @return the amount to be paid or recieved.
	 */
	public double getAmount() {
		return amount;
	}
	
	/** The current player executes the action indicated in the card.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 * @param attack the index of the chosen player of the current player
	 */
	public void doAction(ArrayList<Player> players, int turn, int attack) {
		
		if(this.name.equalsIgnoreCase("Collect From The Bank")) {
			collectBank(players.get(turn));
		}
		else if (this.name.equalsIgnoreCase("Pay The Bank")) {
			payBank(players.get(turn));
		}
		else if (this.name.equalsIgnoreCase("Pay The Player")) {
			payPlayer(players, turn, attack);
		}
		else if (this.name.equalsIgnoreCase("Collect From Player"))
			collectPlayer(players, turn, attack);
		else
			System.out.println("doActionException");
	}
	
	/** Collects from a bank to increase money.
	 * @param player The player doing the action
	 */
	private void collectBank(Player player) {
		player.addCash(amount);
	}
	
	/** Pays the bank to decrease money.
	 * @param player The player doing the action
	 */
	private void payBank(Player player) {
		player.addCash(-amount);
	}
	
	/** Collects money from all players or one specific player to increase money.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 * @param attack The index of the targeted player or -1 if all other players are targets.
	 */
	private void collectPlayer(ArrayList<Player> players, int turn, int attack) {
		
		int i;
		
		if (attack == -1) {
			for (i = 0; i < players.size(); i++) {
				if(i != turn) {
					players.get(turn).addCash(amount);
					players.get(i).addCash(-amount);
				}
			}	
		}
		else if (attack != -1) {
			players.get(turn).addCash(amount);
			players.get(attack).addCash(-amount);
		}
		else
			System.out.println("collectPlayerException");
			
	}
	
	/** Pays money to all players or one specific player to decrease money.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 * @param attack The index of the targeted player or -1 if all other players are targets.
	 */
	private void payPlayer(ArrayList<Player> players, int turn, int attack) {
		
		int i;
		
		if (attack == -1) {
			
			for (i = 0; i < players.size(); i++) {
				if(i != turn) {
					players.get(turn).addCash(-amount);
					players.get(i).addCash(amount);
				}
			}	
		}
		else if (attack != -1) {
			
			players.get(turn).addCash(-amount);
			players.get(attack).addCash(amount);
		}
		else
			System.out.println("payPlayerException");
	}
}

