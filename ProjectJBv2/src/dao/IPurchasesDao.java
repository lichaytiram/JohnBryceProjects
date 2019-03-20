package dao;

import java.util.ArrayList;

import beans.Coupon;
import enums.Category;
import exception.ApplicationException;

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
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and delete id from data base
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void refundCoupon(long customerId, long couponId) throws ApplicationException;

	/**
	 * @param id Receive an id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void refundCoupon(long id) throws ApplicationException;

	/**
	 * @param id     Receive an id
	 * @param amount Receive an amount
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void updateAmount(long id, int amount) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id and check if customer bought that item
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	boolean isCustomerBought(long customerId, long couponId) throws ApplicationException;

	/**
	 * @param id Receive an id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	boolean isCustomerBought(long id) throws ApplicationException;

	/**
	 * @param id Receive an id
	 * @return This function return the amount of coupon that bought by customer
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	int getAmount(long coustomerId) throws ApplicationException;

	/**
	 * @param customerID Receive a customer id
	 * @return This function return all coupons that customer bought by his id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	ArrayList<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException;

	/**
	 * @param customerID Receive a customer id
	 * @param category   Receive a category
	 * @return This function return all coupons that customer bought by his category
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	ArrayList<Coupon> getCustomerCouponByCategory(long customerId, Category category) throws ApplicationException;

	/**
	 * @param customerID Receive a customer id
	 * @param maxPrice   Receive max price
	 * @return This function return all coupons that customer bought by max price
	 *         and his id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	ArrayList<Coupon> getCustomerCouponByMaxPrice(long customerId, double maxPrice) throws ApplicationException;

}
