package coupons.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import coupons.beans.Purchase;
import coupons.beans.UserDataMap;
import coupons.dao.ICouponsDao;
import coupons.dao.ICustomersDao;
import coupons.dao.IPurchasesDao;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.ValidationUtils;

/**
 * This class manage the all function for purchase facade
 * 
 * @author Lichay
 */
@Controller
public class PurchaseController {

	@Autowired
	private IPurchasesDao purchasesDao;
	@Autowired
	private ICouponsDao couponsDao;
	@Autowired
	private ICustomersDao customersDao;

	/**
	 * @param purchase Receive a purchase
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public void purchaseCoupon(Purchase purchase, UserDataMap userData) throws ApplicationException {

		if (purchase == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);

		if (purchase.getCustomerId() != userData.getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(purchase.getCustomerId());
		ValidationUtils.isValidId(purchase.getCouponId());
		ValidationUtils.isValidAmount(purchase.getAmount());

		if (!customersDao.isCustomerExists(purchase.getCustomerId()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		if (!couponsDao.isCouponExists(purchase.getCouponId()))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS, ErrorType.COUPON_IS_NOT_EXISTS.getMessage(),
					false);

		if (!couponsDao.isCouponValid(purchase.getCouponId()))
			throw new ApplicationException(ErrorType.COUPON_IS_OUT_OF_ORDER,
					ErrorType.COUPON_IS_OUT_OF_ORDER.getMessage(), false);

		int amountOfCouponRemain = couponsDao.howMuchCouponsRemain(purchase.getCouponId());

		if (amountOfCouponRemain < purchase.getAmount())
			throw new ApplicationException(ErrorType.COUPON_IS_OUT_OF_ORDER,
					ErrorType.COUPON_IS_OUT_OF_ORDER.getMessage(), false);

		int amountLeft = amountOfCouponRemain - purchase.getAmount();

		couponsDao.updateCoupon(purchase.getCouponId(), amountLeft);

		purchasesDao.purchaseCoupon(purchase);

	}

	/**
	 * @param id Receive an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public void deletePurchase(long id) throws ApplicationException {

		ValidationUtils.isValidId(id);

		if (!purchasesDao.isCustomerPurchase(id))
			throw new ApplicationException(ErrorType.PURCHASE_IS_NOT_EXISTS,
					ErrorType.PURCHASE_IS_NOT_EXISTS.getMessage(), false);

		purchasesDao.deletePurchase(id);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param userData   Receive an userData
	 * @return This function return purchase amount
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public int getPurchaseAmount(long customerId, UserDataMap userData) throws ApplicationException {

		if (userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), true);

		if (userData.getClientType().name().equals("Customer")) {
			if (customerId != userData.getId())
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

		ValidationUtils.isValidId(customerId);

		if (!customersDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		return purchasesDao.getPurchaseAmount(customerId);

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Purchase> getAllPurchases(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		return purchasesDao.getAllPurchases();

	}

	/**
	 * @param customerId Receive a customer id
	 * @param userData   Receive an userData
	 * @return This function return a purchase list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public List<Purchase> getCustomerPurchases(long customerId, UserDataMap userData) throws ApplicationException {

		if (userData.getClientType().name().equals("Customer")) {
			if (customerId != userData.getId())
				throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		}

		if (userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);

		ValidationUtils.isValidId(customerId);

		if (!customersDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		return purchasesDao.getCustomerPurchases(customerId);

	}

}
