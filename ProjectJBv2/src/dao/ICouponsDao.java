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

	public void createCoupon(Coupon coupon) throws ApplicationException;

	public void deleteCoupon(long couponId) throws ApplicationException;

	public void deleteCouponbyCompanyId(long companyId) throws ApplicationException;

	public void updateCoupon(Coupon coupon) throws ApplicationException;

	public void updateCoupon(long couponId, int amount) throws ApplicationException;

	public List<Coupon> getAllCoupon() throws ApplicationException;

	public Coupon getCoupon(long couponId) throws ApplicationException;

	public boolean isCouponExists(long couponId) throws ApplicationException;

	public boolean isCouponExists(long companyId, String title) throws ApplicationException;

	public boolean isCouponValid(long couponId) throws ApplicationException;

	public int howMuchCouponRemain(long couponId) throws ApplicationException;

	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException;

	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category) throws ApplicationException;

	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException;

	public List<Coupon> getCustomerCouponsByCustomerId(long customerId) throws ApplicationException;

	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException;

	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException;

}
