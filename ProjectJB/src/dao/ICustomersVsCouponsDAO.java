package dao;

import java.util.ArrayList;

import javaBeans.Category;
import javaBeans.Coupon;

public interface ICustomersVsCouponsDAO extends IMainDAO {

	void insert(int customerId, int couponId) throws Exception;

	void delete(int customerId, int couponId) throws Exception;

	void update(int oldCustomerId, int newCustomerId, int oldCouponId, int newCouponId) throws Exception;

	public void checkIfCustomerBought(int customerId, int couponId) throws Exception;

	public ArrayList<Coupon> getCustomerCouponByCustomerID(int customerID) throws Exception;

	public ArrayList<Coupon> getCustomerCouponByCategory(int customerID, Category category) throws Exception;

	public ArrayList<Coupon> getCustomerCouponByMaxPrice(int customerID, double maxPrice) throws Exception;
	
}
