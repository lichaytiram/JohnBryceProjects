package beans;

import exception.ApplicationException;

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
	 * @throws ApplicationException throw exception by name
	 */
	public BaseAttribute(long id) throws ApplicationException {
		super();
		setId(id);
	}

	/**
	 * constructor without parameters
	 * 
	 * @throws ApplicationException throw exception by name
	 */
	public BaseAttribute() throws ApplicationException {
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
	 * @throws ApplicationException throw exception by name
	 */
	public void setId(long id) throws ApplicationException {

		if (id > 0)
			this.id = id;
		else
			throw new ApplicationException("Your Id must contain at least 1 digit!");
	}

	/**
	 * @return This function return the id
	 */
	@Override
	public String toString() {
		return "id=" + getId();
	}

}
