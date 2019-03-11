package beans;

import exception.ExceptionName;

/**
 * This class implement a basic attribute for all java beans classes
 * 
 * @author Lichay
 *
 */
public abstract class BaseAttribute {

	// properties

	private long id;

	// constructor
	/**
	 * constructor for create a show for this class
	 * 
	 * @param id receive id for all function that exthends from this abstract class
	 * @throws ExceptionName throw exception by name
	 */
	public BaseAttribute(long id) throws ExceptionName {
		super();
		setId(id);
	}

	/**
	 * constructor without parameters
	 * 
	 * @throws ExceptionName throw exception by name
	 */
	public BaseAttribute() throws ExceptionName {
		super();
	}

	// getter & setter

	/**
	 * @return This function return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id Receive an id and change it for the new one (if it valid)
	 * @throws ExceptionName throw exception by name
	 */
	public void setId(long id) throws ExceptionName {

		if (id > 0)
			this.id = id;
		else
			throw new ExceptionName("Your Id must contain at least 1 digit!");
	}

	/**
	 * @return This function return the id
	 */
	@Override
	public String toString() {
		return "id=" + getId();
	}

}
