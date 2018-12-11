package Project2;

import java.sql.SQLException;

public interface ICustomersVsCouponsDAO2 extends IMainDAO {

	void insert(int customerId, int couponId) throws SQLException;

	void delete(int customerId, int couponId) throws SQLException;

	void update(int oldCustomerId, int newCustomerId, int oldCouponId, int newCouponId) throws SQLException;
}
