package dao;

import javaBeans.Coupon;

public interface ICouponsDAO extends IMainDAO {

	void insert(Coupon c) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(Coupon c, int index) throws Exception;

	Coupon getOneCoupon(int couponID) throws Exception;

	void addCouponPurchase(int customerId, int couponId) throws Exception;

	void deleteCouponPurchase(int customerId, int couponId) throws Exception;

}
