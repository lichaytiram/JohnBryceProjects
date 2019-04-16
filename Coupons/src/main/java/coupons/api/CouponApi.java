package coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.Coupon;
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
	private CouponController couponController;

	/**
	 * @param coupon Receive a coupon
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public long createCoupon(@RequestBody Coupon coupon) throws ApplicationException {

		return couponController.createCoupon(coupon);

	}

	/**
	 * @param couponId  Receive a coupon id
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{couponId}/{companyId}")
	public void deleteCoupon(@PathVariable long couponId, @PathVariable long companyId) throws ApplicationException {

		couponController.deleteCoupon(couponId, companyId);

	}

	/**
	 * @param coupon Receive a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateCoupon(@RequestBody Coupon coupon) throws ApplicationException {

		couponController.updateCoupon(coupon);

	}

	/**
	 * @return This function return coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Coupon> getAllCoupon() throws ApplicationException {

		return couponController.getAllCoupon();

	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/{couponId}")
	public Coupon getCoupon(@PathVariable long couponId) throws ApplicationException {

		return couponController.getCoupon(couponId);

	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return an amount of coupon that remain
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/amount/{amount}")
	public long howMuchCouponRemain(@PathVariable("amount") long couponId) throws ApplicationException {

		return couponController.howMuchCouponRemain(couponId);

	}

	/**
	 * @param companyId Receive a company id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/company/{companyId}")
	public List<Coupon> getCompanyCouponsByCompanyId(@PathVariable("companyId") long companyId)
			throws ApplicationException {

		return couponController.getCompanyCouponsByCompanyId(companyId);

	}

//	/**
//	 * @param companyId Receive a company id
//	 * @param category  Receive a category
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	// 2 function with same start
//	@GetMapping("/category/{companyId}")
//	public List<Coupon> getCompanyCouponsByCategory(@PathVariable("companyId") long companyId,
//			@RequestParam("category1") Category category) throws ApplicationException {
//
//		return couponController.getCompanyCouponsByCategory(companyId, category);
//
//	}

//	/**
//	 * @param companyId Receive a company id
//	 * @param maxPrice  Receive a max price
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping
//	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException {
//
//		return couponController.getCompanyCouponsByMaxPrice(companyId, maxPrice);
//
//	}
//
	/**
	 * @param customerId Receive a customer id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer/{customerId}")
	public List<Coupon> getCustomerCouponByCustomerId(@PathVariable("customerId") long customerId)
			throws ApplicationException {

		return couponController.getCustomerCouponByCustomerId(customerId);

	}

//	/**
//	 * @param customerId Receive a customer id
//	 * @param category   Receive a category
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping("/category/x/{customerId}")
//	public List<Coupon> getCustomerCouponsByCategory(@PathVariable("customerId") long customerId,
//			@RequestParam("category2") Category category) throws ApplicationException {
//
//		return couponController.getCustomerCouponsByCategory(customerId, category);
//
//	}
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param maxPrice   Receive a max price
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping
//	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {
//
//		return couponController.getCustomerCouponsByMaxPrice(customerId, maxPrice);
//
//	}

}
