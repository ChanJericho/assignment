package game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class serves as the Blue card which indicates the player who to pay.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Blue extends Card{

	private String career;
	private double fixedAmt;
	
	/** 
	 * Creates a Blue object, creates a blue card of which the players of the game will perform.
	 * @param career The name of the career/job that will be matched to a player to be paid.
	 * @param fixedAmt The fixed amount that will determine the amount to be paid.
	 */
	Blue(String career, double fixedAmt){
		
		this.career = career;
		this.fixedAmt = fixedAmt;
	}
	
	/** gets the career of the Blue card.
	 * 
	 * @return the career of the Blue card.
	 */
	public String getCareer() {
		return career;
	}
	
	/** gets the fixed amount of the Blue card.
	 * 
	 * @return the fixed amount of the Blue card.
	 */
	public double getFixedAmount() {
		return fixedAmt;
	}
	
	/** The current player executes the action indicated in the card.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	public void doAction(ArrayList<Player> players, int turn) {
		
		if(this.career.equals("Lawyer")) {
			lawsuit(players,  turn);
		}
		else if (this.career.equals("Accountant")) {
			salaryTaxDue(players, turn);
		}
		else if (this.career.equals("Server")) {
			tipServer(players, turn);
		}
		else if (this.career.equals("Doctor")) {
			skiAccident(players, turn);
		}
		else if (this.career.equals("Computer Consultant")) {
			computerRepair(players, turn);
		}
		else if (this.career.equals("Athlete")) {
			worldCup(players, turn);
		}
		else if (this.career.equals("Racecar Driver")) {
			f1Race(players, turn);
		}
		else
			System.out.println("doBlueException");
	}
	
	/** the current player collects money if the player is a lawyer and pays the lawyer or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void lawsuit(ArrayList<Player> players, int turn) {
		
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
			
			players.get(turn).addCash(-this.fixedAmt);
			
			for (int i = 0; i < players.size(); i++) {
				
				if (players.get(i).getCareerCard().getTitle().equals(this.career))	
					players.get(i).addCash(this.fixedAmt);	
			}
		}
			
	}
	
	/** the current player collects money if the player is an accountant and pays the accountant or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void salaryTaxDue(ArrayList<Player> players, int turn) {
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
			
			players.get(turn).addCash(-players.get(turn).getSalaryCard().getTax());
			
			for (int i = 0; i < players.size(); i++) {
			
				if (players.get(i).getCareerCard().getTitle().equals(this.career))
					players.get(i).addCash(players.get(turn).getSalaryCard().getTax());
			}
		}
	}
	
	/** the current player collects money if the player is a Server and pays the Server or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void tipServer(ArrayList<Player> players, int turn) {
		
		Random numGenerator = new Random();
		double toPay = (numGenerator.nextInt(10) + 1) * 1000;
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
			
			players.get(turn).addCash(-toPay);
			
			for (int i = 0; i < players.size(); i++) {
				
				if (players.get(i).getCareerCard().getTitle().equals(this.career))
					players.get(i).addCash(toPay);
			
			}
		}
			
	}
	
	/** the current player collects money if the player is a doctor and pays the doctor or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void skiAccident(ArrayList<Player> players, int turn) {
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
			
			players.get(turn).addCash(-10000);
			
			for (int i = 0; i < players.size(); i++) {
				
				if (players.get(i).getCareerCard().getTitle().equals(this.career))
					players.get(i).addCash(10000);
					
			}
		}
	}
	
	/** the current player collects money if the player is a computer consultant and pays the computer consultant or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void computerRepair(ArrayList<Player> players, int turn) {
		
		Random numGenerator = new Random();
		double toPay;
		
		if (numGenerator.nextInt(2) == 0)
			toPay = 10000;
		else
			toPay = 5000;
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
		
			players.get(turn).addCash(-toPay);
			
			for (int i = 0; i < players.size(); i++) {
				
				if (players.get(i).getCareerCard().getTitle().equals(this.career)) 
					players.get(i).addCash(toPay);
					
			}
		}
	}
	
	/** the current player collects money if the player is an athlete and pays the athlete or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void worldCup(ArrayList<Player> players, int turn) {
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
			
			players.get(turn).addCash(- (players.size() * 5000));
			
			for (int i = 0; i < players.size(); i++) {
				
				if (players.get(i).getCareerCard().getTitle().equals(this.career)) 
					players.get(i).addCash(players.size() * 5000);
				
			}
		}
	}
	
	/** the current player collects money if the player is a racecar driver and pays the racecar driver or bank if it not.
	 * @param players The array list of players
	 * @param turn The index of the current player
	 */
	private void f1Race(ArrayList<Player> players, int turn) {
		
		if (players.get(turn).getCareerCard().getTitle().equals(this.career))
			players.get(turn).addCash(15000);
		else {
			
			players.get(turn).addCash(-(players.get(turn).getSalaryCard().getSalary() * 0.10));
			
			for (int i = 0; i < players.size(); i++) {
				
				if (players.get(i).getCareerCard().getTitle().equals(this.career)) 
					players.get(i).addCash((players.get(turn).getSalaryCard().getSalary() * 0.10));
					
			}
		}
	}
}

