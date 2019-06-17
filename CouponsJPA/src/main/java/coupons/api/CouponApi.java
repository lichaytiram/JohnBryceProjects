package coupons.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import coupons.beans.UserDataMap;
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
	 * @param coupon  Receive a coupon
	 * @param request Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public void createCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		couponController.createCoupon(coupon, userData);

	}

	/**
	 * @param couponId  Receive a coupon id
	 * @param companyId Receive a company id
	 * @param request   Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{couponId}")
	public void deleteCoupon(@PathVariable("couponId") long couponId, @RequestParam("companyId") long companyId,
			HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		couponController.deleteCoupon(couponId, companyId, userData);

	}

	/**
	 * @param coupon  Receive a coupon
	 * @param request Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PutMapping
	public void updateCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		couponController.updateCoupon(coupon, userData);

	}

	/**
	 * @param request Receive a httpServletRequest
	 * @return This function return coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Coupon> getAllCoupons(HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return couponController.getAllCoupons(userData);

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
	 * @param companyId Receive a company id
	 * @param request   Receive a httpServletRequest
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/company")
	public List<Coupon> getCompanyCouponsByCompanyId(@RequestParam("companyId") long companyId,
			HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return couponController.getCompanyCouponsByCompanyId(companyId, userData);

	}

	/**
	 * @param companyId Receive a company id
	 * @param category  Receive a category
	 * @param request   Receive a httpServletRequest
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/company/category")
	public List<Coupon> getCompanyCouponsByCategory(@RequestParam("companyId") long companyId,
			@RequestParam("category") Category category, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return couponController.getCompanyCouponsByCategory(companyId, category, userData);

	}

//	/**
//	 * @param companyId Receive a company id
//	 * @param maxPrice  Receive a max price
//	 * @param request   Receive a httpServletRequest
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping("/company/price")
//	public List<Coupon> getCompanyCouponsByMaxPrice(@RequestParam("companyId") long companyId,
//			@RequestParam("maxPrice") double maxPrice, HttpServletRequest request) throws ApplicationException {
//
//		UserDataMap userData = (UserDataMap) request.getAttribute("userData");
//
//		return couponController.getCompanyCouponsByMaxPrice(companyId, maxPrice, userData);
//
//	}
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param request    Receive a httpServletRequest
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping("/customer")
//	public List<Coupon> getCustomerCouponsByCustomerId(@RequestParam("customerId") long customerId,
//			HttpServletRequest request) throws ApplicationException {
//
//		UserDataMap userData = (UserDataMap) request.getAttribute("userData");
//
//		return couponController.getCustomerCouponsByCustomerId(customerId, userData);
//
//	}
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param category   Receive a category
//	 * @param request    Receive a httpServletRequest
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping("/customer/category")
//	public List<Coupon> getCustomerCouponsByCategory(@RequestParam("customerId") long customerId,
//			@RequestParam("category") Category category, HttpServletRequest request) throws ApplicationException {
//
//		UserDataMap userData = (UserDataMap) request.getAttribute("userData");
//
//		return couponController.getCustomerCouponsByCategory(customerId, category, userData);
//
//	}
//
//	/**
//	 * @param customerId Receive a customer id
//	 * @param maxPrice   Receive a max price
//	 * @param request    Receive a httpServletRequest
//	 * @return This function return a coupon list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	@GetMapping("/customer/price")
//	public List<Coupon> getCustomerCouponsByMaxPrice(@RequestParam("customerId") long customerId,
//			@RequestParam("maxPrice") double maxPrice, HttpServletRequest request) throws ApplicationException {
//
//		UserDataMap userData = (UserDataMap) request.getAttribute("userData");
//
//		return couponController.getCustomerCouponsByMaxPrice(customerId, maxPrice, userData);
//
//	}

}
