package dao;

import java.util.List;

import beans.Purchase;
import exception.ApplicationException;

public interface IPurchasesDao {

	public void purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException;

	public void deletePurchase(long customerId, long couponId) throws ApplicationException;

	public void deletePurchase(long id) throws ApplicationException;

	public void deletePurchaseByCouponId(long couponId) throws ApplicationException;

	public void deletePurchaseByCustomerId(long customerId) throws ApplicationException;

	public void deletePurchaseByCompanyId(long companyId) throws ApplicationException;

	public boolean isCustomerBought(long customerId, long couponId) throws ApplicationException;

	public boolean isCustomerBought(long id) throws ApplicationException;

	public int getPurchaseAmount(long customerId) throws ApplicationException;

	public List<Purchase> getAllPurchase() throws ApplicationException;

	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException;

}
