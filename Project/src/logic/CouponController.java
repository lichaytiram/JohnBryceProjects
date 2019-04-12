package logic;

import java.util.List;

import beans.Coupon;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.CustomersDao;
import dao.ICompaniesDao;
import dao.ICouponsDao;
import dao.ICustomersDao;
import dao.IPurchasesDao;
import dao.PurchasesDao;
import enums.Category;
import enums.ErrorType;
import exception.ApplicationException;
import utils.DateUtils;
import utils.ValidationUtils;

/**
 * This class manage the all function for coupon facade
 * 
 * @author Lichay
 */
public class CouponController {

	private ICouponsDao couponsDao;
	private IPurchasesDao purchasesDao;
	private ICustomersDao customerDao;
	private ICompaniesDao companyDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public CouponController() throws ApplicationException {

		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
		customerDao = new CustomersDao();
		companyDao = new CompaniesDao();

	}

	/**
	 * @param coupon Receive a coupon
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
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

	/**
	 * @param couponId Receive a coupon id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCoupon(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCouponId(couponId);

		couponsDao.deleteCoupon(couponId);

	}

	/**
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteExpiredCoupon() throws ApplicationException {

		purchasesDao.deleteExpiredPurchase();

		couponsDao.deleteExpiredCoupon();

	}

	/**
	 * @param coupon Receive a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
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

	/**
	 * @return This function return coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getAllCoupon() throws ApplicationException {

		return couponsDao.getAllCoupon();

	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Coupon getCoupon(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (couponsDao.isCouponExists(couponId))
			return couponsDao.getCoupon(couponId);

		throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());
	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return an amount of coupon that remain
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long howMuchCouponRemain(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (!couponsDao.isCouponExists(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS.getMessage());

		return couponsDao.howMuchCouponRemain(couponId);

	}

	/**
	 * @param companyId Receive a company id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByCompanyId(long companyId) throws ApplicationException {

		ValidationUtils.isValidId(companyId);

		if (!companyDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCompanyCouponsByCompanyId(companyId);

	}

	/**
	 * @param companyId Receive a company id
	 * @param category  Receive a category
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category) throws ApplicationException {

		ValidationUtils.isValidId(companyId);
		isValidCategory(category);

		if (!companyDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCompanyCouponsByCategory(companyId, category);

	}

	/**
	 * @param companyId Receive a company id
	 * @param maxPrice  Receive a max price
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice) throws ApplicationException {

		ValidationUtils.isValidId(companyId);
		isValidPrice(maxPrice);

		if (!companyDao.isCompanyExists(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCompanyCouponsByMaxPrice(companyId, maxPrice);

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCustomerCouponByCustomerId(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByCustomerId(customerId);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param category   Receive a category
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCustomerCouponsByCategory(long customerId, Category category) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		isValidCategory(category);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByCategory(customerId, category);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param maxPrice   Receive a max price
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCustomerCouponsByMaxPrice(long customerId, double maxPrice) throws ApplicationException {

		ValidationUtils.isValidId(customerId);
		isValidPrice(maxPrice);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return couponsDao.getCustomerCouponsByMaxPrice(customerId, maxPrice);

	}

	/**
	 * @param price Receive a price
	 * @throws ApplicationException This function can throw an applicationException
	 */
	private void isValidPrice(double price) throws ApplicationException {

		if (price <= 0)
			throw new ApplicationException(ErrorType.INVALID_PRICE.getMessage());

	}

	/**
	 * @param category Receive a category
	 * @throws ApplicationException This function can throw an applicationException
	 */
	private void isValidCategory(Category category) throws ApplicationException {

		if (category == null)
			throw new ApplicationException(ErrorType.INVALID_CATEGORY.getMessage());

	}

	/**
	 * @param image Receive an image
	 * @throws ApplicationException This function can throw an applicationException
	 */
	private void isValidImage(String image) throws ApplicationException {

		if (!(image.contains(".")) || image.charAt(image.length() - 1) == '.' || image.charAt(0) == '.')
			throw new ApplicationException(ErrorType.INVALID_IMAGE.getMessage());

	}
}
