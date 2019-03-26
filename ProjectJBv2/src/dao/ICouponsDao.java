package dao;

import java.util.List;

import beans.Coupon;
import enums.Category;
import exception.ApplicationException;

/**
 * This interface will implement by class couponsDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICouponsDao {

	/**
	 * @param c Receive a coupon and insert to data base
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void createCoupon(Coupon c) throws ApplicationException;

	/**
	 * @param couponID Receive a coupon id and delete from data base
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void deleteCoupon(long couponId) throws ApplicationException;

	/**
	 * @param c Receive a coupon and update
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void updateCoupon(Coupon c) throws ApplicationException;

//	/**
//	 * @param couponID  Receive a coupon id
//	 * @param companyID Receive a company id and delete coupon if coupon belongs to
//	 *                  that company
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	public void delete(long couponId, long companyId) throws ApplicationException;

	/**
	 * @return This function retrn all coupons
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	List<Coupon> getAllCoupon() throws ApplicationException;

	/**
	 * @param couponID Receive a coupon id
	 * @return This function return coupon by his id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	Coupon getCoupon(long couponId) throws ApplicationException;

//	/**
//	 * @param customerId Receive a customer id
//	 * @param couponId   Receive a coupon id and add to list purchase (in customer
//	 *                   vs coupons)
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	void addCouponPurchase(long customerId, long couponId) throws ApplicationException;
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param couponId   Receive a coupon id and delete it from list purchase (in
//	 *                   customer vs coupons)
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	void deleteCouponPurchase(long customerId, long couponId) throws ApplicationException;

	/**
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	public List<Coupon> getCompanyCouponsById(long companyId) throws ApplicationException;

	/**
	 * @param maxPrice  Receive a max price
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id and max price
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, long companyId) throws ApplicationException;

	/**
	 * @param category  Receive a category
	 * @param companyID Receive a company id
	 * @return This function return all coupons by his company id and his category
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	public List<Coupon> getCompanyCouponsByCategory(Category category, long companyId) throws ApplicationException;

	/**
	 * @return This function return all id for expired coupons
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	public List<Integer> getAllexpiredCouponsId() throws ApplicationException;

}
