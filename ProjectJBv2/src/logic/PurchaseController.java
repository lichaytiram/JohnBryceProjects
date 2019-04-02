package logic;

import java.util.List;

import beans.Purchase;
import dao.CouponsDao;
import dao.CustomerDao;
import dao.PurchasesDao;
import exception.ApplicationException;
import utils.IdUtils;

/**
 * This class manage the all function for purchase facade
 * 
 * @author Lichay
 */
public class PurchaseController {

	private PurchasesDao purchasesDao;
	private CouponsDao couponsDao;
	private CustomerDao customerDao;

	public PurchaseController() throws ApplicationException {
		purchasesDao = new PurchasesDao();
		couponsDao = new CouponsDao();
		customerDao = new CustomerDao();
	}

	public void purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException {

		IdUtils.isValidId(customerId);
		IdUtils.isValidId(couponId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer id isn't exist!");

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException("Have a problem:\n" + "This coupon id isn't exist!");

		if (!couponsDao.isCouponValid(couponId))
			throw new ApplicationException("Have a problem:\n" + "This coupon id isn't valid anymore!");

		int amountOfCouponFromDataBase = couponsDao.howMuchCouponRemain(couponId);

		if (amountOfCouponFromDataBase < amount)
			throw new ApplicationException(
					"Have a problem:\n" + "Dont have from this coupon enough!\nYou can buy only ["
							+ amountOfCouponFromDataBase + "] coupons");

		int amountLeft = amountOfCouponFromDataBase - amount;
		couponsDao.updateCoupon(couponId, amountLeft);
		purchasesDao.purchaseCoupon(customerId, couponId, amount);

	}

	public void deletePurchase(long customerId, long couponId) throws ApplicationException {
		if (!purchasesDao.isCustomerBought(customerId, couponId)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist from your history!");
		}

		purchasesDao.deletePurchase(customerId, couponId);

	}

	public void deletePurchase(long id) throws ApplicationException {
		if (!purchasesDao.isCustomerBought(id)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist from your history!");
		}

		purchasesDao.deletePurchase(id);

	}

	public int getPurchaseAmount(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer isn't exists");

		return purchasesDao.getPurchaseAmount(customerId);
	}

	public List<Purchase> getAllPurchase() throws ApplicationException {
		return purchasesDao.getAllPurchase();
	}

	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer isn't exists");

		return purchasesDao.getCustomerPurchase(customerId);

	}

}
