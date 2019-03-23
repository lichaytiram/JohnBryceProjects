package logic;

import java.util.ArrayList;

import beans.Coupon;
import dao.CouponsDao;
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

	public PurchaseController() throws ApplicationException {
		purchasesDao = new PurchasesDao();
		couponsDao = new CouponsDao();
	}

	public void purchaseCoupon(long customerId, long couponId, int amount) throws ApplicationException {

		if (!couponsDao.isCouponExists(couponId)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon id isn't exist!");
		}

		if (!couponsDao.isCouponValid(couponId))
			throw new ApplicationException("Have a problem:\n" + "This coupon id isn't valid anymore!");

		long amountOfCouponFromDataBase = couponsDao.howMuchCouponRemain(couponId);
		if (amountOfCouponFromDataBase < amount) {
			throw new ApplicationException("Have a problem:\n"
					+ "Dont have from this coupon enough!\nYou can buy only [" + amountOfCouponFromDataBase + "]");
		}

		purchasesDao.purchaseCoupon(customerId, couponId, amount);

	}

	public void refundCoupon(long customerId, long couponId) throws ApplicationException {
		if (!purchasesDao.isCustomerBought(customerId, couponId)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist from your history!");
		}

		purchasesDao.refundCoupon(customerId, couponId);

	}

	public void refundCoupon(long id) throws ApplicationException {
		if (!purchasesDao.isCustomerBought(id)) {
			throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist from your history!");
		}

		purchasesDao.refundCoupon(id);

	}

	public int getAmount(long customerId) throws ApplicationException {
		// and change for 1 coupon id?

		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getAmount(customerId);
		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

	public ArrayList<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {
		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getCustomerCouponsByCustomerId(customerId);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

	public ArrayList<Coupon> getCustomerCouponsByCategory(long customerId, Category category)
			throws ApplicationException {
		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getCustomerCouponsByCategory(customerId, category);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

	public ArrayList<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice)
			throws ApplicationException {

		if (purchasesDao.isCustomerBoughtByCoustomerId(customerId))
			return purchasesDao.getCustomerCouponsByMaxPrice(customerId, maxPrice);

		throw new ApplicationException("Have a problem:\n" + "This customer isn't buy any coupon");

	}

}
