package dao;

import java.util.ArrayList;

import beans.Category;
import beans.Coupon;

/**
 * This interface will implement by class customerVsCouponsDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICustomersVsCouponsDao extends IMainDao {

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and insert to data base
	 * @throws Exception Can throw an exception
	 */
	void insert(int customerId, int couponId) throws Exception;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and delete id from data base
	 * @throws Exception Can throw an exception
	 */
	void delete(int customerId, int couponId) throws Exception;

	/**
	 * @param oldCustomerId Receive an old customer id
	 * @param newCustomerId Receive a new customer id and replace them
	 * @param oldCouponId   Receive an old coupon id
	 * @param newCouponId   Receive a new coupon id and replace them
	 * @throws Exception Can throw an exception
	 */
	void update(int oldCustomerId, int newCustomerId, int oldCouponId, int newCouponId) throws Exception;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and check if customer bought that item
	 * @throws Exception Can throw an exception
	 */
	public void checkIfCustomerBought(int customerId, int couponId) throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @return This function return all coupons that customer bought by his id
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCouponByCustomerID(int customerID) throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @param category   Receive a category
	 * @return This function return all coupons that customer bought by his category
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCouponByCategory(int customerID, Category category) throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @param maxPrice   Receive max price
	 * @return This function return all coupons that customer bought by max price
	 *         and his id
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCustomerCouponByMaxPrice(int customerID, double maxPrice) throws Exception;

}
