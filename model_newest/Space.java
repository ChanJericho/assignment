package game.model;


/**
 * This class serves as the spaces of a segment in the board
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Space {
	
	private String color;
	private int number;
	
	/** 
	 * Creates a space object with the given color and number, which serves as the spaces in a segment.
	 * @param color
	 * @param number
	 */
	public Space(String color, int number){
		this.color = color;
		this.number = number;
	}
	
	/** 
	 * Creates a space object with the given color only, which serves as the spaces in a segment.
	 * @param color
	 */
	public Space(String color) {
		this.color = color;
		this.number = -1;
	}
	
	/** Returns the color of the space
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/** Returns the number of index that will decide for magenta and green spaces what to do. 
	 * @return the number of index
	 */
	public int getNumber() {
		return number;
	}
}

