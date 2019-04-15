package dao;

import exception.ApplicationException;

/**
 * This interface shared for all package dao like a main interface
 * 
 * @author Lichay
 *
 */

public interface ICreate {

	/**
	 * Create tables in the data base
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	void create() throws ApplicationException;

	/**
	 * Drop the data base
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	void drop() throws ApplicationException;

}
