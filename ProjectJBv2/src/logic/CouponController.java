package logic;

import java.util.List;

import beans.Coupon;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.CustomersDao;
import dao.PurchasesDao;
import enums.Category;
import enums.ErrorType;
import exception.ApplicationException;
import utils.DateUtils;
import utils.ValidationUtils;

public class CouponController {

	private CouponsDao couponsDao;
	private PurchasesDao purchasesDao;
	private CustomersDao customerDao;
	private CompaniesDao companyDao;

	public CouponController() {

		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
		customerDao = new CustomersDao();
		companyDao = new CompaniesDao();

	}

	public long createCoupon(Coupon coupon) throws ApplicationException {

		if (coupon == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		ValidationUtils.isValidId(coupon.getCompanyId());
		isValidCategory(coupon.getCategory());
		ValidationUtils.isValidName(coupon.getTitle());
		DateUtils.isValidDate(coupon.getStartDate(), coupon.getEndDate());
		ValidationUtils.isValidAmount(coupon.getAmount());
		isValidPrice(coupon.getPrice());
		isValidImage(coupon.getImage());

		if (couponsDao.isCouponExists(coupon.getId()))
			throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage());

		if (couponsDao.isCouponExists(coupon.getCompanyId(), coupon.getTitle()))
			throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage());

		return couponsDao.createCoupon(coupon);

	}

	public void deleteCoupon(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCouponId(couponId);

		couponsDao.deleteCoupon(couponId);

	}

	public void updateCoupon(Coupon coupon) throws ApplicationException {

		if (coupon == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		ValidationUtils.isValidId(coupon.getId());
		ValidationUtils.isValidId(coupon.getCompanyId());
		isValidCategory(coupon.getCategory());
		ValidationUtils.isValidName(coupon.getTitle());
		DateUtils.isValidDate(coupon.getStartDate(), coupon.getEndDate());
		ValidationUtils.isValidAmount(coupon.getAmount());
		isValidPrice(coupon.getPrice());
		isValidImage(coupon.getImage());

		if (!couponsDao.isCouponExists(coupon.getId()))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		Coupon couponFromDataBase = couponsDao.getCoupon(coupon.getId());

		if (!couponFromDataBase.getTitle().equals(coupon.getTitle())) {

			if (couponsDao.isCouponExists(coupon.getCompanyId(), coupon.getTitle()))

				throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage());

		}

		couponsDao.updateCoupon(coupon);

	}

	public List<Coupon> getAllCoupon() throws ApplicationException {

		return couponsDao.getAllCoupon();

	}

	public Coupon getCoupon(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (couponsDao.isCouponExists(couponId))
			return couponsDao.getCoupon(couponId);

		throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());
	}

	public long howMuchCouponRemain(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		return couponsDao.howMuchCouponRemain(couponId);

	}

	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!companyDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCompanyCouponsByCompanyId(companyId);

	}

	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category) throws ApplicationException {

		ValidationUtils.isValidId(companyId);
		isValidCategory(category);

		if (!companyDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCompanyCouponsByCategory(companyId, category);

	}

	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException {

		ValidationUtils.isValidId(companyId);
		isValidPrice(maxPrice);

		if (!companyDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCompanyCouponsByMaxPrice(companyId, maxPrice);

	}

	public List<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByCustomerId(customerId);

	}

	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		isValidCategory(category);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByCategory(customerId, category);

	}

	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		isValidPrice(maxPrice);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByMaxPrice(customerId, maxPrice);

	}

	private void isValidPrice(double price) throws ApplicationException {

		if (price <= 0)
			throw new ApplicationException(ErrorType.INVALID_PRICE.getMessage());

	}

	private void isValidCategory(Category category) throws ApplicationException {

		if (category == null)
			throw new ApplicationException(ErrorType.INVALID_CATEGORY.getMessage());

	}

	private void isValidImage(String image) throws ApplicationException {

		if (!(image.contains(".")) || image.charAt(image.length() - 1) == '.' || image.charAt(0) == '.')
			throw new ApplicationException(ErrorType.INVALID_IMAGE.getMessage());

	}
}
