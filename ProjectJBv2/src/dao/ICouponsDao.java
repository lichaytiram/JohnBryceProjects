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

//	/**
//	 * @param c Receive a coupon and insert to data base
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	void createCoupon(Coupon c) throws ApplicationException;
//
//	/**
//	 * @param couponID Receive a coupon id and delete from data base
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	void deleteCoupon(long couponId) throws ApplicationException;
//
//	/**
//	 * @param c Receive a coupon and update
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	void updateCoupon(Coupon c) throws ApplicationException;
//
//	/**
//	 * @return This function retrn all coupons
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	List<Coupon> getAllCoupon() throws ApplicationException;
//
//	/**
//	 * @param couponID Receive a coupon id
//	 * @return This function return coupon by his id
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	Coupon getCoupon(long couponId) throws ApplicationException;
//
//	/**
//	 * @param companyID Receive a company id
//	 * @return This function return all coupons by his company id
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException;
//
//	/**
//	 * @param maxPrice  Receive a max price
//	 * @param companyID Receive a company id
//	 * @return This function return all coupons by his company id and max price
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice, long companyId) throws ApplicationException;
//
//	/**
//	 * @param category  Receive a category
//	 * @param companyID Receive a company id
//	 * @return This function return all coupons by his company id and his category
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	public List<Coupon> getCompanyCouponsByCategory(Category category, long companyId) throws ApplicationException;
//
//	/**
//	 * @return This function return all id for expired coupons
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	public List<Integer> getAllexpiredCouponsId() throws ApplicationException;
//
//	/**
//	 * @param customerID Receive a customer id
//	 * @return This function return all coupons that customer bought by his id
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	List<Coupon> getCustomerCouponsByCustomerId(long customerId) throws ApplicationException;
//
//	/**
//	 * @param customerID Receive a customer id
//	 * @param category   Receive a category
//	 * @return This function return all coupons that customer bought by his category
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException;
//
//	/**
//	 * @param customerID Receive a customer id
//	 * @param maxPrice   Receive max price
//	 * @return This function return all coupons that customer bought by max price
//	 *         and his id
//	 * @throws ApplicationException Can throw an ApplicationException
//	 */
//	List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException;

}
