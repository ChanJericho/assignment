package game.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class serves as the Houses that can be purchased.
 * @author James Louis Lemsic
 * @author Jericho Chan
 * @version 1.0
 */
public class Salary extends Card{

	ArrayList<Double> salaryRange;
	ArrayList<Double> taxRange;
	
	double salary;
	double tax;
	
	/** 
	 * Creates a Salary object, creates a salary that the players can have.
	 */
	public Salary() {
		
		int i;		
		Random index = new Random();
		salaryRange = new ArrayList<Double>();
		taxRange = new ArrayList<Double>();
		
		salaryRange.add((double) 30000);
		salaryRange.add((double) 120000);
		
		for (i = 0; i < 2; i++) {
			salaryRange.add((double) 40000);
			salaryRange.add((double) 110000);
		}
		
		for (i = 0; i < 3; i++) {
			salaryRange.add((double) 50000);
			salaryRange.add((double) 100000);
		}
		
		for (i = 0; i < 4; i++) {
			salaryRange.add((double) 90000);
			salaryRange.add((double) 60000);
		}
		
		for (i = 0; i < 5; i++) {
			salaryRange.add((double) 70000);
			salaryRange.add((double) 80000);
		}
		
		salary = salaryRange.get(index.nextInt(30));
		tax = salary/10;
	}
	
	/** gets the salary.
	 * @param
	 * @return the salary.
	 */
	public double getSalary() {
		return salary;
	}
	
	/** gets the tax.
	 * @param
	 * @return the tax.
	 */
	public double getTax() {
		return tax;
	}
	
	/** increases the Salary.
	 * @param amt the amount to be added to the salary.
	 */
	public void addSalary(double amt) {
		salary += amt;
	}
	
	/** increases the tax.
	 * @param amt the amount to be added to the salary.
	 */
	public void addTax(double amt) {
		tax += amt;
	}
	
	/** prints everything, making it less hassle to display the details, an Override Function.
	 * 
	 * @return String representation with this object's salary and tax.
	 */
	@Override
	public String toString() {
		return "Salary: " + salary + "\nTax: " + tax;
	}
}

