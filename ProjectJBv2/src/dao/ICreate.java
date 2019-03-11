package dao;

/**
 * This interface shared for all packege dao like a main interface
 * 
 * @author Lichay
 *
 */
public interface ICreate {

	/**
	 * Create a table in data base
	 * 
	 * @throws Exception Can throw an exception
	 */

	void create() throws Exception;

	/**
	 * Drop a data base
	 * 
	 * @throws Exception Can throw an exception
	 */
	void drop() throws Exception;

}
