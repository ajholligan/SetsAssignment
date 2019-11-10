import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author aholl
 * This class controls the program it contains the menu and also calls all of the correct methods
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tester test = new Tester();
		test.control();
		

	}

	private Lottery lottery;
	
	/**
	 * Creates new lottery object when constructor is called
	 */
	public Tester()
	{ 
		lottery = new Lottery();
	}
	
	/**
	 * Controls the order of methods being called
	 */
	public void control()
	{
		do
		{
			
			for(int i = 0; i < lottery.getNumWeeks(); i++)
			{
				lottery.makeDraw();
			 
				for (int j = 0; j < lottery.getNumPlayers(); j++)
				{
					lottery.checkWin(j);
					System.out.println("Your account balence is now £" + lottery.getPeople()[j].getWinnings());
				}
			}
			
		}
		while(quit());
		 
	}
	
	/**
	 * This method asks the user for one of their numbers and validates the input
	 * @param count int shows which of the 6 numbers are to be entered
	 * @param i int shows which player is being asked for numbers
	 * @return int the number to be added to the set
	 */
	public static int promptPlayerNum(int count, int i)
	{ 
		try
		{
			i++;
			System.out.println("Player " + i + " Please enter number " + count +" of 6");
			Scanner s = new Scanner(System.in);
			return s.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only numerical values");
			i--;
			return Tester.promptPlayerNum(count, i);
		}
	}
	
	/**
	 * This method asks the user for the range and validates the input
	 * @return int temp contains the range of the lottery
	 */
	public static int promptPlayerRange()
	{
		try
		{
			System.out.println("Please enter the range of lottery");
			Scanner s = new Scanner(System.in);
			int temp = s.nextInt();
			if(temp< 6)
			{
				System.out.println("This range is too small it must be at least 6");
				return Tester.promptPlayerRange();
			}
			return temp;
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only numerical values");
			return Tester.promptPlayerRange();
		}
		
	}
	
	/**
	 * This method asks the user for the number of players and validates the input
	 * @return int the number of players
	 */
	public static int promptNumPlayers()
	{ 
		try
		{
			System.out.println("Please enter the number of players");
			Scanner s = new Scanner(System.in);
			return s.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only numerical values");
			return Tester.promptNumPlayers();
		}
	}
	
	/**
	 * This method asks the user for the number of weeks and validates the input
	 * @return int number of weeks
	 */
	public static int promptNumWeeks()
	{
		try
		{
			System.out.println("Please enter the number of weeks you would like to run these numbers for");
			Scanner s = new Scanner(System.in);
			return s.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only numerical values");
			return Tester.promptNumWeeks();
		}
	}
	/**
	 * This method checks if the user would like to quit
	 * @return boolean whether the user wishes to quit
	 */
	public boolean quit()
	{
		try
		{
			System.out.println("Would you like to play again y/n");
			Scanner s = new Scanner(System.in);
			String answer = s.nextLine();
			if(answer.equals("y"))
			{
				lottery = new Lottery();
				return true;
			}
			else if (answer.equals("n"))
			{
				System.out.println("Thank you for playing");
				return false;
			}
			else 
			{
				throw new InputMismatchException();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter only y or n");
			return quit();
		}
	}

}
