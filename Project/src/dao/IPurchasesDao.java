package dao;

import java.util.List;

import beans.Purchase;
import exception.ApplicationException;

public interface IPurchasesDao {

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @param amount     Receive an amount
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException;

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
	public boolean isCustomerBought(long customerId, long couponId) throws ApplicationException;

	/**
	 * @param id Receive an id
	 * @return This function return true if customer bought
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public boolean isCustomerBought(long id) throws ApplicationException;

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
