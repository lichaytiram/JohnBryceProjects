package Project2;

import java.sql.SQLException;

public interface ICustomersDAO extends IMainDAO {

	void insert(String firstName, String lastName, String email, String password) throws SQLException;

	void delete(int indexToDelete) throws SQLException;

	void update(String firstName, String lastName, String email, String passWord, int index) throws SQLException;
}
