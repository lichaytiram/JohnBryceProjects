package dao;

import java.util.ArrayList;

import beans.Coupon;
import enums.Category;

/**
 * This interface will implement by class customerVsCouponsDBDAO
 * 
 * @author Lichay
 *
 */
public interface IPurchasesDao {

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and insert to data base
	 * @param amount     Receive an amount
	 * @throws Exception Can throw an exception
	 */
	void purchaseCoupon(long customerId, long couponId, int amount) throws Exception;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and delete id from data base
	 * @throws Exception Can throw an exception
	 */
	void refundCoupon(long customerId, long couponId) throws Exception;

	/**
	 * @param id Receive an id
	 * @throws Exception Can throw an exception
	 */
	void refundCoupon(long id) throws Exception;

	/**
	 * @param id     Receive an id
	 * @param amount Receive an amount
	 * @throws Exception Can throw an exception
	 */
	void updateAmount(long id, int amount) throws Exception;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and check if customer bought that item
	 * @throws Exception Can throw an exception
	 */
	boolean isCustomerBought(long customerId, long couponId) throws Exception;

	/**
	 * @param id Receive an id
	 * @throws Exception Can throw an exception
	 */
	boolean isCustomerBought(long id) throws Exception;

	/**
	 * @param id Receive an id
	 * @return This function return the amount of coupon that bought by customer
	 * @throws Exception Can throw an exception
	 */
	int getAmount(long id) throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @return This function return all coupons that customer bought by his id
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Coupon> getCustomerCouponByCustomerId(long customerId) throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @param category   Receive a category
	 * @return This function return all coupons that customer bought by his category
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Coupon> getCustomerCouponByCategory(long customerId, Category category) throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @param maxPrice   Receive max price
	 * @return This function return all coupons that customer bought by max price
	 *         and his id
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Coupon> getCustomerCouponByMaxPrice(long customerId, double maxPrice) throws Exception;

}
