package logic;

import java.util.List;

import beans.Purchase;
import dao.CouponsDao;
import dao.CustomersDao;
import dao.PurchasesDao;
import enums.ErrorType;
import exception.ApplicationException;
import utils.ValidationUtils;

/**
 * This class manage the all function for purchase facade
 * 
 * @author Lichay
 */
public class PurchaseController {

	private PurchasesDao purchasesDao;
	private CouponsDao couponsDao;
	private CustomersDao customerDao;

	public PurchaseController() throws ApplicationException {

		purchasesDao = new PurchasesDao();
		couponsDao = new CouponsDao();
		customerDao = new CustomersDao();

	}

	public long purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		ValidationUtils.isValidId(couponId);
		ValidationUtils.isValidAmount(amount);

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
		return purchasesDao.purchaseCoupon(customerId, couponId, amount);

	}

	public void deletePurchase(long customerId, long couponId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		ValidationUtils.isValidId(couponId);

		if (!purchasesDao.isCustomerBought(customerId, couponId))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchase(customerId, couponId);

	}

	public void deletePurchase(long id) throws ApplicationException {

		ValidationUtils.isValidId(id);

		if (!purchasesDao.isCustomerBought(id))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchase(id);

	}

	public int getPurchaseAmount(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return purchasesDao.getPurchaseAmount(customerId);

	}

	public List<Purchase> getAllPurchase() throws ApplicationException {

		return purchasesDao.getAllPurchase();

	}

	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return purchasesDao.getCustomerPurchase(customerId);

	}

}
