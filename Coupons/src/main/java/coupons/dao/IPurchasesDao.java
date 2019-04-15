package coupons.dao;

import java.util.List;

import coupons.beans.Purchase;
import coupons.exception.ApplicationException;

public interface IPurchasesDao {

	/**
	 * @param purchase Receive a purchase
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long purchaseCoupon(Purchase purchase) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchase(long customerId, long couponId) throws ApplicationException;

	/**
	 * @param id Receive an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchase(long id) throws ApplicationException;

	/**
	 * @param couponId Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchaseByCouponId(long couponId) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchaseByCustomerId(long customerId) throws ApplicationException;

	/**
	 * @param companyId Receive a company id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchaseByCompanyId(long companyId) throws ApplicationException;

	/**
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteExpiredPurchase() throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @return This function return true if customer bought
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public boolean isCustomerPurchase(long customerId, long couponId) throws ApplicationException;

	/**
	 * @param id Receive an id
	 * @return This function return true if customer bought
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public boolean isCustomerPurchase(long id) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @return This function return purchase amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public int getPurchaseAmount(long customerId) throws ApplicationException;

	/**
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Purchase> getAllPurchase() throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException;

}
