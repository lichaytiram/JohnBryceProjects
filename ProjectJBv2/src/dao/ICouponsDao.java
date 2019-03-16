package dao;

import java.util.ArrayList;

import beans.Coupon;
import enums.Category;

/**
 * This interface will implement by class couponsDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICouponsDao {

	/**
	 * @param c Receive a coupon and insert to data base
	 * @throws Exception Can throw an exception
	 */
	void createCoupon(Coupon c) throws Exception;

	/**
	 * @param couponID Receive a coupon id and delete from data base
	 * @throws Exception Can throw an exception
	 */
	void deleteCoupon(long couponId) throws Exception;

	/**
	 * @param c Receive a coupon and update
	 * @throws Exception Can throw an exception
	 */
	void updateCoupon(Coupon c) throws Exception;

//	/**
//	 * @param couponID  Receive a coupon id
//	 * @param companyID Receive a company id and delete coupon if coupon belongs to
//	 *                  that company
//	 * @throws Exception Can throw an exception
//	 */
//	public void delete(long couponId, long companyId) throws Exception;

	/**
	 * @return This function retrn all coupons
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Coupon> getAllCoupon() throws Exception;

	/**
	 * @param couponID Receive a coupon id
	 * @return This function return coupon by his id
	 * @throws Exception Can throw an exception
	 */
	Coupon getCoupon(long couponId) throws Exception;

//	/**
//	 * @param customerId Receive a customer id
//	 * @param couponId   Receive a coupon id and add to list purchase (in customer
//	 *                   vs coupons)
//	 * @throws Exception Can throw an exception
//	 */
//	void addCouponPurchase(long customerId, long couponId) throws Exception;
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param couponId   Receive a coupon id and delete it from list purchase (in
//	 *                   customer vs coupons)
//	 * @throws Exception Can throw an exception
//	 */
//	void deleteCouponPurchase(long customerId, long couponId) throws Exception;

	/**
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCouponsById(long companyId) throws Exception;

	/**
	 * @param maxPrice  Receive a max price
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id and max price
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, long companyId) throws Exception;

	/**
	 * @param category  Receive a category
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id and his category
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCouponsByCategory(Category category, long companyId) throws Exception;

	/**
	 * @return This function return all id for expired coupons
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Integer> getAllexpiredCouponsId() throws Exception;

}
