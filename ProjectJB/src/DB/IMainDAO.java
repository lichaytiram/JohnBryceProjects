package DB;

import java.sql.SQLException;

public interface IMainDAO {

	void create() throws Exception;

	void drop() throws Exception;

	void showAll() throws Exception;

}
