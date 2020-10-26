package game.model;

/**
 * This class serves as the Houses that can be purchased.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class House extends Card{
	
	private String name;
	private double value;
	private double tax;
	
	/** 
	 * Creates a House object, creates a House card that can be bought and owned by the players.
	 * @param name The name of the house.
	 * @param value The price/value of the house.
	 * @param tax The tax of the house.
	 */
	public House(String name, double value, double tax){
		this.name = name;
		this.value = value;
		this.tax = tax;
	}
	
	/** Gets the name of the house.
	 * 
	 * @return the name of the house.
	 */
	public String getName() {
		return name;
	}
	
	/** Gets the value of the house.
	 * 
	 * @return the value of the house.
	 */
	public double getValue() {
		return value;
	}
	
	/** Gets the tax of the house.
	 * 
	 * @return the tax of the house.
	 */
	public double getTax() {
		return tax;
	}
	
	/** prints everything, making it less hassle to display the details, an Override Function.
	 * 
	 * @return String representation with this object's value and tax.
	 */
	@Override
	public String toString() {
		return name + "\nValue: " + value + "\nTax: " + tax;
	}
}
