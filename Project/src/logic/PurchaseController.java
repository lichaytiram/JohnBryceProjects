package logic;

import java.util.List;

import beans.Purchase;
import dao.CouponsDao;
import dao.CustomersDao;
import dao.ICouponsDao;
import dao.ICustomersDao;
import dao.IPurchasesDao;
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

	private IPurchasesDao purchasesDao;
	private ICouponsDao couponsDao;
	private ICustomersDao customerDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public PurchaseController() throws ApplicationException {

		purchasesDao = new PurchasesDao();
		couponsDao = new CouponsDao();
		customerDao = new CustomersDao();

	}

	/**
	 * @param purchase Receive a purchase
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long purchaseCoupon(Purchase purchase) throws ApplicationException {

		if (purchase == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidId(purchase.getCustomerId());
		ValidationUtils.isValidId(purchase.getCouponId());
		ValidationUtils.isValidAmount(purchase.getAmount());

		if (!customerDao.isCustomerExists(purchase.getCustomerId()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		if (!couponsDao.isCouponExists(purchase.getCouponId()))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS, ErrorType.COUPON_IS_NOT_EXISTS.getMessage(),
					false);

		if (!couponsDao.isCouponValid(purchase.getCouponId()))
			throw new ApplicationException(ErrorType.COUPON_IS_OUT_OF_ORDER,
					ErrorType.COUPON_IS_OUT_OF_ORDER.getMessage(), false);

		int amountOfCouponRemain = couponsDao.howMuchCouponRemain(purchase.getCouponId());

		if (amountOfCouponRemain < purchase.getAmount())
			throw new ApplicationException(ErrorType.COUPON_IS_OUT_OF_ORDER,
					ErrorType.COUPON_IS_OUT_OF_ORDER.getMessage(), false);

		int amountLeft = amountOfCouponRemain - purchase.getAmount();

		couponsDao.updateCoupon(purchase.getCouponId(), amountLeft);

		return purchasesDao.purchaseCoupon(purchase);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param couponId   Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchase(long customerId, long couponId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		ValidationUtils.isValidId(couponId);

		if (!purchasesDao.isCustomerBought(customerId, couponId))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS,
					ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage(), false);

		purchasesDao.deletePurchase(customerId, couponId);

	}

	/**
	 * @param id Receive an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deletePurchase(long id) throws ApplicationException {

		ValidationUtils.isValidId(id);

		if (!purchasesDao.isCustomerBought(id))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS,
					ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage(), false);

		purchasesDao.deletePurchase(id);

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return purchase amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public int getPurchaseAmount(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		return purchasesDao.getPurchaseAmount(customerId);

	}

	/**
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Purchase> getAllPurchase() throws ApplicationException {

		return purchasesDao.getAllPurchase();

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Purchase> getCustomerPurchase(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		return purchasesDao.getCustomerPurchase(customerId);

	}

}
