import java.util.Set;
import java.util.HashSet;
import java.util.Random;


/**
 * @author aholl
 *This class makes a lottery draw and finds winners
 */
public class Lottery {



	private int range;
	private SetWrapper draw;
	private SetWrapper userSet;
	private int numPlayers;
	private Person[] people;
	private int numWeeks;
	
	/**
	 * @return the numWeeks
	 */
	public int getNumWeeks() {
		return numWeeks;
	}

	/**
	 * @param numWeeks the numWeeks to set
	 */
	public void setNumWeeks(int numWeeks) {
		this.numWeeks = numWeeks;
	}

	/**
	 * Constructor initalises all fields and calls method to create people
	 */
	public Lottery()
	{
		numPlayers = Tester.promptNumPlayers();
		range = Tester.promptPlayerRange();
		people = new Person[numPlayers];
		numWeeks = Tester.promptNumWeeks();
		initialisePeople();
	}
	
	/**
	 * @return the userSet
	 */
	public SetWrapper getUserSet() {
		return userSet;
	}

	/**
	 * @param userSet the userSet to set
	 */
	public void setUserSet(SetWrapper userSet) {
		this.userSet = userSet;
	}

	/**
	 * @return the draw
	 */
	public SetWrapper getDraw() {
		return draw;
	}

	/**
	 * @param draw the draw to set
	 */
	public void setDraw(SetWrapper draw) {
		this.draw = draw;
	}

	/**
	 * This method generates a random number between 1 and the range of the lottery
	 * @return int num random number
	 */
	public int randomNumber()
	{
	    Random randGenerator = new Random();
	    int num;
	    num = (randGenerator.nextInt(range)) + 1;

	    return num;
	}
	
	/**
	 * This method gets 6 random numbers and adds them to a set
	 */
	public void makeDraw()
	{ 
		SetWrapper lottoDraw = new SetWrapper();
		while (lottoDraw.getCardinality() != 6)
		{ 
			lottoDraw.addToSet(randomNumber());
		}
		setDraw(lottoDraw);
	}	 
	

	
	/**
	 * Checks how many numbers match
	 * @return int matches the number of matching numbers for that player
	 */
	public int checkNumMatch()
	{ 
		System.out.println("This weeks numbers are");
		draw.printSet();
		SetWrapper winning = new SetWrapper(userSet.intersection(draw));
		int matches = winning.getCardinality();
		return matches;
	}
	
	/**
	 * This method outputs how much the player won
	 * @param i int array index for player
	 */
	public void checkWin(int i)
	{ 
		Person temp[] = people.clone();
		
	
		setUserSet(temp[i].getNumbers());
		int match = checkNumMatch();
		int playerNum = i+1;
		
		if(match == 6)
		{
			System.out.println("Player " + playerNum + " Congratulations you won the jackpot!!! you matched all 6 numbers");
			people[i].setWinnings(people[i].getWinnings()+1000000-2);
		}
		else if(match == 5)
		{
			System.out.println("Player " + playerNum + " Congratulations you won £1,000! you matched 5 out of the 6 numbers");
			people[i].setWinnings(people[i].getWinnings()+1000-2);
		}
		else if(match == 4)
		{
			System.out.println("Player " + playerNum + " Congratulations you won £100! you matched 4 out of the 6 numbers");
			people[i].setWinnings(people[i].getWinnings()+100-2);
		}
		else if(match == 3)
		{
			System.out.println("Player " + playerNum + " Congratulations you won £25! you matched 3 out of the 6 numbers");
			people[i].setWinnings(people[i].getWinnings()+25-2);
		}
		else
		{ 
			System.out.println("Player " + playerNum + " Unfortunatly you only matched "+ match + " out of the 6 numbers so you have not won");
			people[i].setWinnings(people[i].getWinnings()-2);
		}
			
	}
	
	
	/**
	 * @return the people
	 */
	public Person[] getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(Person[] people) {
		this.people = people;
	}

	/**
	 * @return the numPlayers
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * @param numPlayers the numPlayers to set
	 */
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	/**
	 * This method fills the array of person objects
	 */
	public void initialisePeople()
	{ 
		for(int i = 0; i < people.length;i++ )
		{
			SetWrapper s = new SetWrapper();
			int count = 1;
			while(s.getCardinality()!=6)
			{
				int num = Tester.promptPlayerNum(count, i);
				if(num <= range && num > 0)
				{
					if(s.addToSet(num))
					{
						count++;
					}
					else
					{
						System.out.println("You cannot have duplicate numbers please enter a diferent number");
					}
					
				}
				else
				{ 
					System.out.println("This value is out of range of the lotter it must be between 0 and " +range);
				}
			}
			people[i] = new Person(s);
		}

	}
	
}
