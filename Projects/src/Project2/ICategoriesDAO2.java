package Project2;

import java.sql.SQLException;

public interface ICategoriesDAO2 extends IMainDAO {

	void insert(String Name) throws SQLException;

	void delete(int indexToDelete) throws SQLException;

	void update(String Name, int index) throws SQLException;
}
