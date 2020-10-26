package game.model;

/**
 * This class serves as the careers for the players.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Career extends Card{
	
	private String title;
	private int payRaise;
	private boolean degreeReq;
	
	/** 
	 * Creates a Career object, creates a career of which the players of the game will possess.
	 * @param title the name of the career/job
	 * @param min The minimum value of the pay raise range
	 * @param max The maximum value of the pay raise range
	 * @param degReq The indicator if the career needs a degree or not
	 */
	public Career(String title, int min, int max, boolean degReq) {
		this.title = title;
		payRaise = (int) (Math.random() * (max - min + 1) + min);
		this.degreeReq = degReq;
	}
	
	/** Gets the Title of the career.
	 *
	 * @return the title of career
	 */
	public String getTitle() {
		return title;
	}
	
	/** Gets the Pay Raise value of the career.
	 * 
	 * @return the generated Raise for this career
	 */
	public int getPayRaise() {
		return payRaise;
	}
	
	
	/** Gets the degree requirement of the career (true if a degree is required; otherwise, not).
	 * @return the boolean value indicating if the career needs a degree or not
	 */
	public boolean isDegRequired() {
		return degreeReq;
	}
	
	/** subtracts the available raises of a player
	 */
	public void minusPayRaise() {
		payRaise -= 1;
	}
	
	/** prints everything, making it less hassle to display the details, an Override Function.
	 * 
	 * @return String representation with this object's title, pay raise value, and boolean value of degree requirement
	 */
	@Override
	public String toString() {
		return title + "\nRaise: " + payRaise + "\nDegree: " + degreeReq;
	}
}
