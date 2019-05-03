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
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public void purchaseCoupon(@RequestBody Purchase purchase, HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		purchaseController.purchaseCoupon(purchase, userData.getId());

	}

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/delete")
	public void deletePurchase(@RequestParam("customerId") long customerId, @RequestParam("couponId") long couponId,
			HttpServletRequest request) throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		purchaseController.deletePurchase(userData.getId(), couponId);

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
	 * @return This function return purchase amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer/amount")
	public int getPurchaseAmount(@RequestParam("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return purchaseController.getPurchaseAmount(userData.getId());

	}

	/**
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping
	public List<Purchase> getAllPurchase() throws ApplicationException {

		return purchaseController.getAllPurchase();

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@GetMapping("/customer")
	public List<Purchase> getCustomerPurchase(@RequestParam("customerId") long customerId, HttpServletRequest request)
			throws ApplicationException {

		UserDataMap userData = (UserDataMap) request.getAttribute("userData");

		return purchaseController.getCustomerPurchase(userData.getId());

	}

}
