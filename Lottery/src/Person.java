/**
 * 
 */

/**
 * @author aholl
 *
 */
public class Person {

	private SetWrapper numbers;
	private int winnings;
	
	/**
	 * Constructor for a new person
	 * @param set of lottery numbers 
	 */
	public Person(SetWrapper set)
	{
		numbers = set;
		winnings = 0 ;
	}
	
	/**
	 * @return the numbers
	 */
	public SetWrapper getNumbers() {
		return numbers;
	}
	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(SetWrapper numbers) {
		this.numbers = numbers;
	}
	/**
	 * @return the winnings
	 */
	public int getWinnings() {
		return winnings;
	}
	/**
	 * @param winnings the winnings to set
	 */
	public void setWinnings(int winnings) {
		this.winnings = winnings;
	}
	
	
	
}
