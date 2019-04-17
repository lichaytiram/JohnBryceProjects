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
import org.springframework.web.bind.annotation.RequestParam;
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
	@DeleteMapping("/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") long couponId, @RequestParam("companyId") long companyId)
			throws ApplicationException {

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
	@GetMapping("/amount/{couponId}")
	public long howMuchCouponRemain(@PathVariable("couponId") long couponId) throws ApplicationException {

		return couponController.howMuchCouponRemain(couponId);

	}

	/**
	 * @param companyId Receive a company id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/company")
	public List<Coupon> getCompanyCouponsByCompanyId(@RequestParam("companyId") long companyId)
			throws ApplicationException {

		return couponController.getCompanyCouponsByCompanyId(companyId);

	}

	/**
	 * @param companyId Receive a company id
	 * @param category  Receive a category
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/company/category")
	public List<Coupon> getCompanyCouponsByCategory(@RequestParam("companyId") long companyId,
			@RequestParam("category") Category category) throws ApplicationException {

		return couponController.getCompanyCouponsByCategory(companyId, category);

	}

	/**
	 * @param companyId Receive a company id
	 * @param maxPrice  Receive a max price
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/company/price")
	public List<Coupon> getCompanyCouponsByMaxPrice(@RequestParam("companyId") long companyId,
			@RequestParam("maxPrice") double maxPrice) throws ApplicationException {

		return couponController.getCompanyCouponsByMaxPrice(companyId, maxPrice);

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer")
	public List<Coupon> getCustomerCouponsByCustomerId(@RequestParam("customerId") long customerId)
			throws ApplicationException {

		return couponController.getCustomerCouponsByCustomerId(customerId);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param category   Receive a category
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer/category")
	public List<Coupon> getCustomerCouponsByCategory(@RequestParam("customerId") long customerId,
			@RequestParam("category") Category category) throws ApplicationException {

		return couponController.getCustomerCouponsByCategory(customerId, category);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param maxPrice   Receive a max price
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer/price")
	public List<Coupon> getCustomerCouponsByMaxPrice(@RequestParam("customerId") long customerId,
			@RequestParam("maxPrice") double maxPrice) throws ApplicationException {

		return couponController.getCustomerCouponsByMaxPrice(customerId, maxPrice);

	}

}
