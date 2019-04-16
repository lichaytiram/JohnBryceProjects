package coupons.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons.beans.Purchase;
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
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@PostMapping
	public long purchaseCoupon(@RequestBody Purchase purchase) throws ApplicationException {

		return purchaseController.purchaseCoupon(purchase);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@DeleteMapping("/{customerId}/{couponId}")
	public void deletePurchase(@PathVariable("customerId") long customerId, @PathVariable("couponId") long couponId)
			throws ApplicationException {

		purchaseController.deletePurchase(customerId, couponId);

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
	@GetMapping("amount/{customerId}")
	public int getPurchaseAmount(@PathVariable("customerId") long customerId) throws ApplicationException {

		return purchaseController.getPurchaseAmount(customerId);

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
	@GetMapping("/{customerId}")
	public List<Purchase> getCustomerPurchase(@PathVariable("customerId") long customerId) throws ApplicationException {

		return purchaseController.getCustomerPurchase(customerId);

	}

}
