import java.util.Set;
import java.util.HashSet;
/**
 * 
 */

/**
 * @author aholl
 *
 */
public class SetWrapper {
	
	/**
	 * @return the set
	 */
	public Set<Integer> getSet() {
		return set;
	}

	/**
	 * @param set the set to set
	 */
	public void setSet(Set<Integer> set) {
		this.set = set;
	}

	private Set<Integer> set;

	/**
	 * Constructor makes new Set using HashSet class
	 */
	public SetWrapper()
	{ 
		set = new HashSet<Integer>();
	}
	
	/**
	 * Constructor makes new Set using HashSet class
	 * @param setInput a set to be put into the set wrapper
	 */
	public SetWrapper(Set<Integer> setInput)
	{ 
		set = new HashSet<Integer>(setInput);
	}
	
	/**
	 * adds a value into the set
	 * @param value int to be put in the set
	 * @return returns boolean answer of add function
	 */
	public boolean addToSet(int value)
	{ 
		return set.add(value);
		
	}
	
	/**
	 * prints out all the values in the set
	 */
	public void printSet()
	{ 
		System.out.println(set);
	}
	
	/**
	 * Checks if the set is empty
	 * @return boolean empty or not
	 */
	public boolean isEmpty()
	{ 
		return set.isEmpty();
	}
	
	/**
	 * Checks the size of the set
	 * @return int size of the set
	 */
	public int getCardinality()
	{
		return set.size();
	}
	
	/**
	 * Finds the intersection of the 2 sets
	 * @param sets SwtWrapper to be intersected with the current Set
	 * @return set which contains the intersecrion
	 */
	public Set<Integer> intersection(SetWrapper sets)
	{
		Set<Integer> tempSet = new HashSet(set);
		tempSet.retainAll(sets.getSet());
		return tempSet;
		
	}
	
	/**
	 * Checks if a value is in the set or not
	 * @param value int value to be checked
	 * @return boolean contains or not
	 */
	public boolean isInSet(int value)
	{ 
		return set.contains(value);
	}
	
}
