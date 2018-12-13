package DB;

import java.sql.SQLException;

public interface ICategoriesDAO2 extends IMainDAO {

	void insert(String Name) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(String Name, int index) throws Exception;
}
