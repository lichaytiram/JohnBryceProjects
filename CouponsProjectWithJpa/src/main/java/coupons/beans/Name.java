package coupons.beans;

/**
 * This class create a name
 * 
 * @author Lichay
 *
 */
public class Name {

	// property

	private String name;

	// constructor

	/**
	 * Constructor for create a show for this class
	 * 
	 * @param name Receive a name
	 */
	public Name(String name) {
		this();
		this.name = name;
	}

	/**
	 * Constructor for create a show for this class
	 */
	public Name() {
		super();
	}

	// getter & setter

	/**
	 * @return This function return a name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Receive a name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name [name=" + getName() + "]";
	}

}
