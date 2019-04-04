package logic;

import java.util.List;

import beans.Purchase;
import dao.CouponsDao;
import dao.CustomerDao;
import dao.PurchasesDao;
import enums.ErrorType;
import exception.ApplicationException;
import utils.AmountUtils;
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
		AmountUtils.isValidAmount(amount);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		if (!couponsDao.isCouponValid(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_OUT_OF_ORDER.getMessage());

		int amountOfCouponRemain = couponsDao.howMuchCouponRemain(couponId);

		if (amountOfCouponRemain < amount)
			throw new ApplicationException(ErrorType.COUPON_IS_OUT_OF_ORDER.getMessage());

		int amountLeft = amountOfCouponRemain - amount;

		couponsDao.updateCoupon(couponId, amountLeft);
		purchasesDao.purchaseCoupon(customerId, couponId, amount);

	}

	public void deletePurchase(long customerId, long couponId) throws ApplicationException {

		IdUtils.isValidId(customerId);
		IdUtils.isValidId(couponId);

		if (!purchasesDao.isCustomerBought(customerId, couponId))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchase(customerId, couponId);

	}

	public void deletePurchase(long id) throws ApplicationException {

		IdUtils.isValidId(id);

		if (!purchasesDao.isCustomerBought(id))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchase(id);

	}

	public int getPurchaseAmount(long customerId) throws ApplicationException {

		IdUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return purchasesDao.getPurchaseAmount(customerId);

	}

	public List<Purchase> getAllPurchase() throws ApplicationException {

		return purchasesDao.getAllPurchase();

	}

	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException {

		IdUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return purchasesDao.getCustomerPurchase(customerId);

	}

}
