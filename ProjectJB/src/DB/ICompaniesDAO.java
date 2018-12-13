package DB;

import java.sql.SQLException;

public interface ICompaniesDAO extends IMainDAO {

	void insert(String name, String email, String password) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(String name, String email, String passWord, int index) throws Exception;
}
