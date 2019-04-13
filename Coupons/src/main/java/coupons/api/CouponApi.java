package coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.Coupon;
import coupons.enums.Category;
import coupons.exception.ApplicationException;
import coupons.logic.CouponController;

/**
 * This class create api with the server
 * 
 * @author Lichay
 *
 */
@RestController
@RequestMapping("/coupons")
public class CouponApi {

	@Autowired
	private CouponController couponController = null;

	// constructor

	/**
	 * Create instance for this class
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public CouponApi() throws ApplicationException {

		couponController = new CouponController();

	}

	/**
	 * @param coupon Receive a coupon
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createCoupon(Coupon coupon) throws ApplicationException {

		return couponController.createCoupon(coupon);

	}

	/**
	 * @param couponId Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCoupon(long couponId) throws ApplicationException {

		couponController.deleteCoupon(couponId);

	}

	// ask if need click for it? or only by thread
//	/**
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void deleteExpiredCoupon() throws ApplicationException {
//		
//		couponController.deleteExpiredCoupon();
//		
//	}

	/**
	 * @param coupon Receive a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCoupon(Coupon coupon) throws ApplicationException {

		couponController.updateCoupon(coupon);

	}

	/**
	 * @return This function return coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getAllCoupon() throws ApplicationException {

		return couponController.getAllCoupon();

	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Coupon getCoupon(long couponId) throws ApplicationException {

		return couponController.getCoupon(couponId);

	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return an amount of coupon that remain
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long howMuchCouponRemain(long couponId) throws ApplicationException {

		return couponController.howMuchCouponRemain(couponId);

	}

	/**
	 * @param companyId Receive a company id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException {

		return couponController.getCompanyCouponsByCompanyId(companyId);

	}

	/**
	 * @param companyId Receive a company id
	 * @param category  Receive a category
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category) throws ApplicationException {

		return couponController.getCompanyCouponsByCategory(companyId, category);

	}

	/**
	 * @param companyId Receive a company id
	 * @param maxPrice  Receive a max price
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException {

		return couponController.getCompanyCouponsByMaxPrice(companyId, maxPrice);

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {

		return couponController.getCustomerCouponByCustomerId(customerId);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param category   Receive a category
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException {

		return couponController.getCustomerCouponsByCategory(customerId, category);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param maxPrice   Receive a max price
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {

		return couponController.getCustomerCouponsByMaxPrice(customerId, maxPrice);

	}

}
