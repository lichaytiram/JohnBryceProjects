package dao;

import java.util.ArrayList;

import javaBeans.Coupon;

public interface ICouponsDAO extends IMainDAO {

	void insert(Coupon c) throws Exception;

	void delete(int couponID) throws Exception;

	void update(Coupon c, int index) throws Exception;

	ArrayList<Coupon> getAllCoupon() throws Exception;

	Coupon getOneCoupon(int couponID) throws Exception;

	void addCouponPurchase(int customerId, int couponId) throws Exception;

	void deleteCouponPurchase(int customerId, int couponId) throws Exception;

}
