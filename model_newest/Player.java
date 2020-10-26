package game.model;

import java.util.Random;

/**
 * This class serves as the players of the game.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Player {
	
	private String name;
	private int position;
	private int path;
	private boolean degree;
	private double money;
	private boolean married;
	private Career career;
	private Salary salary;
	private House house;
	private int children;
	private boolean retirement;
	private double loan;
	private double finalMoney;
	private int rank;
	
	/** 
	 * Creates a player object, creates a player that moves on the board.
	 * @param name The name of the player.
	 */
	Player(String name){
		
		this.name = name;
		position = -1;
		path = 0;
		degree = false;
		money = 200000;
		married = false;
		career = new Career("Student", 0, 0, false);
		salary = new Salary();
		house = new House("Parent's house", 0, 0);
		children = 0;
		retirement = false;
		loan = 0;
		finalMoney = 0;
		rank = 0;
	}
	
	/** rolls for a random number from 1 - 10.
	 *
	 * @return the generated number
	 */
	public int roll() {
		
		Random dice = new Random();
		return dice.nextInt(10) + 1; 
	}
	
	/** sets the rank of the player in the game.
	 * @param rank the new rank of the player.
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/** sets the Career of the player in the game.
	 * @param career the new career of the player.
	 */
	public void setCareer(Card card) {
		this.career = (Career) card;
	}
	
	/** sets the Salary of the player in the game.
	 * @param salary the new salary of the player.
	 */
	public void setSalary(Card salary) {
		this.salary = (Salary) salary;
	}
	
	/** sets the House of the player in the game.
	 * @param hosue the new house of the player.
	 */
	public void setHouse(Card house) {
		this.house = (House) house;
	}
	
	/** sets the degree of the player (true if there is a degree; otherwise, none).
	 * @param degree the boolean value indicating if the player has a degree.
	 */
	public void setDegree(boolean degree) {
		this.degree = degree;
	}
	
	/** sets the position of the player in a segment.
	 * @param pos the new position of the player in a segment.
	 */
	public void setPos(int pos) {
		position = pos;
	}
	
	/** sets the path of the player in the board.
	 * @param path the new path of the player in the board.
	 */
	public void setPath(int path) {
		this.path = path;
	}
	
	/** gets the rank of the player in the game.
	 *
	 * @return the rank of the player.
	 */
	public int getRank() {
		return rank;
	}

	/** gets the name of the player.
	 *
	 * @return the name of the player.
	 */
	public String getName() {
		return name;
	}
	
	/** gets the position of the player in a segment.
	 *
	 * @return the position of the player in a segment.
	 */
	public int getPos() {
		return position;
	}
	
	/** gets the path of the player in the board.
	 *
	 * @return the path of the player in the board.
	 */
	public int getPath() {
		return path;
	}
	
	/** gets the amount of money the player has.
	 *
	 * @return the amount of money the player has.
	 */
	public double getMoney() {
		return money;
	}
	
	/** gets the career of the player.
	 *
	 * @return the career of the player.
	 */
	public Career getCareerCard() {
		return career;
	}
	
	/** gets the salary of the player.
	 *
	 * @return the salary of the player.
	 */
	public Salary getSalaryCard() {
		return salary;
	}
	
	/** gets the house of the player.
	 *
	 * @return the house of the player.
	 */
	public House getHouse() {
		return house;
	}
	
	/** gets the number of children the player has.
	 *
	 * @return the number of children the player has.
	 */
	public int getChildren() {
		return children;
	}
	
	/** gets the marriage status of the player (true if the player is married; otherwise, not).
	 * 
	 * @return the boolean value indicating the marriage status of the player.
	 */
	public boolean getMarried() {
		return married;
	}
	
	/** gets the degree status of the player (true if the player has a degree; otherwise, none).
	 *
	 * @return the boolean value indicating if the player has a degree or not.
	 */
	public boolean getDegree() {
		return degree;
	}
	
	/** gets the retirement status of the player (true if the player is retired; otherwise, not).
	 * 
	 * @return the boolean value indicating if the player is retired or not.
	 */
	public boolean getStatusRetirement() {
		return retirement;
	}
	
	/** gets the outstanding loan of the player.
	 * @param
	 * @return the outstanding loan of the player.
	 */
	public double getLoan() {
		return loan;
	}
	
	/** gets the final score of the player.
	 * @param
	 * @return the final score of the player.
	 */
	public double getFinalMoney() {
		return finalMoney;
	}
	
	/** Increases the amount of money the player has.
	 * @param amt the amount to be added.
	 */
	public void addCash(double amt) {
		money += amt;
	}
	
	/** increases the final score of the player.
	 * @param amt the amount to be added
	 */
	public void addFinalMoney(double amt) {
		this.finalMoney += amt;
	}
	
	/** increases the children of the player.
	 * @param
	 * @return amt the amount of children to be added.
	 */
	public void addChildren(int amt) {
		children += amt;
	}
	
	/** loans for 20,000 and 25,000 will be added to the loan.
	 *
	 */
	public void bankLoan() {
		this.loan += 25000;
		this.money += 20000;
	}
	
	/** the player retires and the retirement staus becomes true.
	 * 
	 */
	public void retire() {
		retirement = true;
	}
	
	/** the player marries and the married status becomes true.
	 *
	 */
	public void marry() {
		this.married = true;
	}

}

