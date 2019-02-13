package dao;

import java.util.ArrayList;

import javaBeans.Category;
import javaBeans.Coupon;

public interface ICouponsDAO extends IMainDAO {

	void insert(Coupon c) throws Exception;

	void delete(int couponID) throws Exception;

	void update(Coupon c) throws Exception;

	ArrayList<Coupon> getAllCoupon() throws Exception;

	Coupon getOneCoupon(int couponID) throws Exception;

	void addCouponPurchase(int customerId, int couponId) throws Exception;

	void deleteCouponPurchase(int customerId, int couponId) throws Exception;

	public ArrayList<Coupon> getCompanyCouponsByID(int companyID) throws Exception;

	public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, int companyID) throws Exception;

	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category, int companyID) throws Exception;
}
