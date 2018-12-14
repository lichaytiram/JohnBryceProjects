package DB;

public interface ICustomersDAO extends IMainDAO {

	void insert(String firstName, String lastName, String email, String password) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(String firstName, String lastName, String email, String passWord, int index) throws Exception;
}
