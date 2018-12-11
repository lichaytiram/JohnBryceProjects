package Project2;

import java.sql.SQLException;
import java.util.Date;

public interface ICouponsDAO2 extends IMainDAO {

	void insert(int companyId, int categoryId, String title, String text, Date startDate, Date endDate, Integer amount,
			float price, String image) throws SQLException;

	void delete(int indexToDelete) throws SQLException;

	void update(int companyId, int categoryId, String title, String text, Date startDate, Date endDate, Integer amount,
			float price, String image, int index) throws SQLException;
}
