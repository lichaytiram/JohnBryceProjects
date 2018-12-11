package Project2;

import java.sql.SQLException;

public interface ICompaniesDAO extends IMainDAO {

	void insert(String name, String email, String password) throws SQLException;

	void delete(int indexToDelete) throws SQLException;

	void update(String name, String email, String passWord, int index) throws SQLException;
}
