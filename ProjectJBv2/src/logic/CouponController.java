package logic;

import java.util.List;

import beans.Coupon;
import dao.CouponsDao;
import dao.CustomerDao;
import dao.PurchasesDao;
import enums.Category;
import enums.ErrorType;
import exception.ApplicationException;
import utils.AmountUtils;
import utils.DateUtils;
import utils.IdUtils;
import utils.NameUtils;

public class CouponController {

	private CouponsDao couponsDao;
	private PurchasesDao purchasesDao;
	private CustomerDao customerDao;

	public CouponController() {

		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
		customerDao = new CustomerDao();

	}

	public void createCoupon(Coupon coupon) throws ApplicationException {

		if (coupon == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		NameUtils.isValidName(coupon.getTitle());
		DateUtils.isValidDate(coupon.getStartDate(), coupon.getEndDate());
		AmountUtils.isValidAmount(coupon.getAmount());
		isValidPrice(coupon.getPrice());

		if (couponsDao.isCouponExists(coupon))
			throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage());

		couponsDao.createCoupon(coupon);

	}

	public void deleteCoupon(long couponId) throws ApplicationException {

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCouponId(couponId);

		couponsDao.deleteCoupon(couponId);

	}

	public void updateCoupon(Coupon coupon) throws ApplicationException {

		if (coupon == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		IdUtils.isValidId(coupon.getId());
		NameUtils.isValidName(coupon.getTitle());
		DateUtils.isValidDate(coupon.getStartDate(), coupon.getEndDate());
		AmountUtils.isValidAmount(coupon.getAmount());
		isValidPrice(coupon.getPrice());

		if (!couponsDao.isCouponExists(coupon.getId()))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		couponsDao.updateCoupon(coupon);

	}

	public List<Coupon> getAllCoupon() throws ApplicationException {

		return couponsDao.getAllCoupon();

	}

	public Coupon getCoupon(long couponId) throws ApplicationException {

		if (couponsDao.isCouponExists(couponId))
			return couponsDao.getCoupon(couponId);

		throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());
	}

	public long howMuchCouponRemain(long couponId) throws ApplicationException {

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		return couponsDao.howMuchCouponRemain(couponId);

	}

	public List<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByCustomerId(customerId);

	}

	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByCategory(customerId, category);

	}

	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByMaxPrice(customerId, maxPrice);

	}

	private void isValidPrice(double price) throws ApplicationException {

		if (price <= 0)
			throw new ApplicationException(ErrorType.INVALID_PRICE.getMessage());

	}

}
