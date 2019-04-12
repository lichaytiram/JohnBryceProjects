package coupons.dao;

import coupons.exception.ApplicationException;

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
	 * @throws Exception Can throw an exception
	 */

	void create() throws ApplicationException;

	/**
	 * Drop the data base
	 * 
	 * @throws Exception Can throw an exception
	 */
	void drop() throws ApplicationException;

}
