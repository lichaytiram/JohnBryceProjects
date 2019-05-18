package coupons.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.Purchase;
import coupons.beans.UserDataMap;
import coupons.exception.ApplicationException;
import coupons.logic.PurchaseController;

/**
 * This class create api with the server
 * 
 * @author Lichay
 *
 */
@RestController
@RequestMapping("/purchases")
public class PurchaseApi {

	@Autowired
	private PurchaseController purchaseController;

	/**
	 * @param purchase Receive a purchase
	 * @param request  Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public void purchaseCoupon(@RequestBody Purchase purchase, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		purchaseController.purchaseCoupon(purchase, userData);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @param request    Receive a httpServletRequest
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/delete")
	public void deletePurchase(@RequestParam("customerId") long customerId, @RequestParam("couponId") long couponId,
			HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		purchaseController.deletePurchase(customerId, couponId, userData);

	}

	/**
	 * @param id Receive an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{id}")
	public void deletePurchase(@PathVariable("id") long id) throws ApplicationException {

		purchaseController.deletePurchase(id);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param request    Receive a httpServletRequest
	 * @return This function return purchase amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/amount")
	public int getPurchaseAmount(@RequestParam("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return purchaseController.getPurchaseAmount(customerId, userData);

	}

	/**
	 * @param request Receive a httpServletRequest
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Purchase> getAllPurchases(HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return purchaseController.getAllPurchases(userData);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param request    Receive a httpServletRequest
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer")
	public List<Purchase> getCustomerPurchase(@RequestParam("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return purchaseController.getCustomerPurchase(customerId, userData);

	}

}
