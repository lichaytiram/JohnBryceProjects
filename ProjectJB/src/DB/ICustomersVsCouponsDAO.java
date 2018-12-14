package DB;

public interface ICustomersVsCouponsDAO extends IMainDAO {

	void insert(int customerId, int couponId) throws Exception;

	void delete(int customerId, int couponId) throws Exception;

	void update(int oldCustomerId, int newCustomerId, int oldCouponId, int newCouponId) throws Exception;
}
