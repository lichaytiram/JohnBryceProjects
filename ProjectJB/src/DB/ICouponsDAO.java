package DB;

import java.util.Date;

public interface ICouponsDAO extends IMainDAO {

	void insert(int companyId, int categoryId, String title, String text, Date startDate, Date endDate, Integer amount,
			float price, String image) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(int companyId, int categoryId, String title, String text, Date startDate, Date endDate, Integer amount,
			float price, String image, int index) throws Exception;
}
