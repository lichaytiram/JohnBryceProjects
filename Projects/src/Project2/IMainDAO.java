package Project2;

import java.sql.SQLException;

public interface IMainDAO {

	void create() throws SQLException;

	void drop() throws SQLException;

	void showAll() throws SQLException;

}
