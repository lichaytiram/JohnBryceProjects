package beans;

import exception.ApplicationException;

/**
 * This class create a company
 * 
 * @author Lichay
 *
 */
public class Company extends SecondBaseAttribute {

	// properties

	private String name;

	// constructor

	/**
	 * constructor for create a show for this class
	 * 
	 * @param id       Receive an id
	 * @param password Receive a password
	 * @param email    Receive an email
	 * @param name     Receive a name for company
	 * @throws ApplicationException Throw an exception by name
	 */
	public Company(long id, String password, String email, String name) throws ApplicationException {
		super(id, password, email);
		setName(name);

	}

	/**
	 * constructor for create a show for this class
	 * 
	 * @param password Receive a password
	 * @param email    Receive an email
	 * @param name     Receive a name for company
	 * @throws ApplicationException Throw an exception by name
	 */
	public Company(String password, String email, String name) throws ApplicationException {
		super(password, email);
		setName(name);

	}

	// getter & setter

	/**
	 * @return this function return a name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name This function set a new name if valid
	 * @throws ApplicationException Throw an exception by name
	 */
	public void setName(String name) throws ApplicationException {
		if (name.length() < 2)
			throw new ApplicationException("Your company name is invalid (must contain at least 2 letters)");
		this.name = name;
	}

	/**
	 * @return This function return as string all attributes
	 */
	@Override
	public String toString() {
		return "Company->[" + super.toString() + ", name=" + getName() + "]";
	}

}