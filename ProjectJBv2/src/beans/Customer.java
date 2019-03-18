package beans;

import exception.ApplicationException;

/**
 * This class create a customer
 * 
 * @author Lichay
 *
 */
public class Customer extends SecondBaseAttribute {

	// properties

	private String firstName;
	private String lastName;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id        Receive an id
	 * @param password  Receive a password
	 * @param email     Receive an email
	 * @param firstName Receive a first name
	 * @param lastName  Receive a last name
	 * @throws ApplicationException Throw an exception by name
	 */
	public Customer(int id, String password, String email, String firstName, String lastName)
			throws ApplicationException {
		super(id, password, email);
		setFirstName(firstName);
		setLastName(lastName);
	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param password  Receive a password
	 * @param email     Receive an email
	 * @param firstName Receive a first name
	 * @param lastName  Receive a last name
	 * @throws ApplicationException Throw an exception by name
	 */
	public Customer(String password, String email, String firstName, String lastName) throws ApplicationException {
		super(password, email);
		setFirstName(firstName);
		setLastName(lastName);
	}

	// getter & setter

	/**
	 * @return This function return a first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Name will be first big latter and after small latter
	 * 
	 * @param firstName This function receive a first name and change the last one
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setFirstName(String firstName) throws ApplicationException {
		if (firstName.length() < 2)
			throw new ApplicationException("Your first name must contain at least two letters");
		this.firstName = firstName.charAt(0) <= 'Z'
				? firstName.charAt(0) + firstName.substring(1, firstName.length()).toLowerCase()
				: (char) (firstName.charAt(0) - 32) + firstName.substring(1, firstName.length()).toLowerCase();
	}

	/**
	 * @return This function return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * name will be first big latter and after small latter
	 * 
	 * @param lastName This function receive a last name and change the last one
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setLastName(String lastName) throws ApplicationException {
		if (lastName.length() < 2)
			throw new ApplicationException("Your last name must contain at least two letters");
		this.lastName = lastName.charAt(0) <= 'Z'
				? lastName.charAt(0) + lastName.substring(1, lastName.length()).toLowerCase()
				: (char) (lastName.charAt(0) - 32) + lastName.substring(1, lastName.length()).toLowerCase();
	}

	/**
	 * @return This function return as string all attributes
	 */
	@Override
	public String toString() {
		return "Customer->[" + super.toString() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + "]";
	}

}
