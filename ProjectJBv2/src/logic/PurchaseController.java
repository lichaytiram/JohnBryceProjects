package logic;

import java.util.List;

import beans.Coupon;
import dao.CouponsDao;
import dao.CustomerDao;
import dao.PurchasesDao;
import enums.Category;
import exception.ApplicationException;

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

	public void deleteCoupon(long customerId, long couponId) throws ApplicationException {
		if (!purchasesDao.isCustomerBought(customerId, couponId)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist from your history!");
		}

		purchasesDao.deleteCoupon(customerId, couponId);

	}

	public void deleteCoupon(long id) throws ApplicationException {
		if (!purchasesDao.isCustomerBought(id)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist from your history!");
		}

		purchasesDao.deleteCoupon(id);

	}

	public int getAmount(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer isn't exists");

		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getAmount(customerId);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

	public List<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer isn't exists");

		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getCustomerCouponsByCustomerId(customerId);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer isn't exists");

		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getCustomerCouponsByCategory(customerId, category);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer isn't exists");

		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getCustomerCouponsByMaxPrice(customerId, maxPrice);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

}
