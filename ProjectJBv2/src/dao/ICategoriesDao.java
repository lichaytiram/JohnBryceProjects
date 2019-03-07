package dao;

/**
 * This interface will implement by class categoriesDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICategoriesDao extends IMainDao {

	/**
	 * @param Name Receive a name to add
	 * @throws Exception Can throw an exception
	 */
	void insert(String Name) throws Exception;

	/**
	 * @param indexToDelete Receive index to delete from data base
	 * @throws Exception Can throw an exception
	 */
	void delete(int indexToDelete) throws Exception;

	/**
	 * @param Name  Receive a name
	 * @param index Receive an index indicate where delete
	 * @throws Exception Can throw an exception
	 */
	void update(String Name, int index) throws Exception;
}
