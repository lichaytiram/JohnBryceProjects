package coupons.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import coupons.beans.Coupon;
import coupons.enums.Category;
import coupons.exception.ApplicationException;

/**
 * This interface will implement while running
 * 
 * @author Lichay
 *
 */
public interface ICouponsDao extends CrudRepository<Coupon, Long> {
	
	public boolean existsByCompanyIdAndTitle(long companyId,String title);

	public boolean existsByIdAndCompanyId(long couponId,long companyId);
	
//	/**
//	 * @param coupon Receive a coupon
//	 * @return This function return an id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public long createCoupon(Coupon coupon) throws ApplicationException;
//
//	/**
//	 * @param couponId Receive a coupon id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void deleteCoupon(long couponId) throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void deleteCouponbyCompanyId(long companyId) throws ApplicationException;
//
//	/**
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void deleteExpiredCoupon() throws ApplicationException;
//
//	/**
//	 * @param coupon Receive a coupon
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void updateCoupon(Coupon coupon) throws ApplicationException;
//
//	/**
//	 * @param couponId Receive a coupon id
//	 * @param amount   Receive an amount
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void updateCoupon(long couponId, int amount) throws ApplicationException;
//
//	/**
//	 * @return This function return coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getAllCoupons() throws ApplicationException;
//
//	/**
//	 * @param couponId Receive a coupon id
//	 * @return This function return a coupon
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public Coupon getCoupon(long couponId) throws ApplicationException;
//
//	/**
//	 * @param couponId Receive a coupon id
//	 * @return This function return true if coupon exists
//	 * @throws ApplicationException This function can throw an applicationException
//	 * 
//	 */
//	public boolean isCouponExists(long couponId) throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @param title     Receive a title
//	 * @return This function return true if coupon exists
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public boolean isCouponExists(long companyId, String title) throws ApplicationException;
//
//	/**
//	 * @param couponId Receive a coupon id
//	 * @return This function return true if coupon valid
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public boolean isCouponValid(long couponId) throws ApplicationException;
//
//	/**
//	 * @param couponId  Receive a coupon id
//	 * @param companyId Receive a company id
//	 * @return This function return true if coupon belong to company
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public boolean isCouponBelongToCompany(long couponId, long companyId) throws ApplicationException;
//
//	/**
//	 * @param couponId Receive a coupon id
//	 * @return This function return an amount of coupon that remain
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public int howMuchCouponsRemain(long couponId) throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @param category  Receive a category
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category) throws ApplicationException;
//
//	/**
//	 * @param companyId Receive a company id
//	 * @param maxPrice  Receive a max price
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException;
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getCustomerCouponsByCustomerId(long customerId) throws ApplicationException;
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param category   Receive a category
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException;
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param maxPrice   Receive a max price
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException;

}
