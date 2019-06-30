package coupons.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import coupons.beans.Company;
import coupons.beans.Coupon;
import coupons.beans.UserDataMap;
import coupons.dao.ICompaniesDao;
import coupons.dao.ICouponsDao;
import coupons.enums.Category;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.DateUtils;
import coupons.utils.ValidationUtils;

/**
 * This class manage the all function for coupon facade
 * 
 * @author Lichay
 */
@Controller
public class CouponController {

	@Autowired
	private ICouponsDao couponsDao;
	@Autowired
	private ICompaniesDao companiesDao;

	/**
	 * @param coupon   Receive a coupon
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public void createCoupon(Coupon coupon, UserDataMap userData) throws ApplicationException {

		if (coupon == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getCompanyId() != coupon.getCompany().getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(coupon.getCompany().getId());
		ValidationUtils.isValidCategory(coupon.getCategory());
		ValidationUtils.isValidName(coupon.getTitle());
		DateUtils.isValidDate(coupon.getStartDate(), coupon.getEndDate());
		ValidationUtils.isValidAmount(coupon.getAmount());
		ValidationUtils.isValidPrice(coupon.getPrice());
		ValidationUtils.isValidImage(coupon.getImage());

		if (couponsDao.existsById(coupon.getId()))
			throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS,
					ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage(), false);

		if (couponsDao.existsByCompanyIdAndTitle(coupon.getCompany().getId(), coupon.getTitle()))
			throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS,
					ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage(), false);

		Company company = companiesDao.findById(coupon.getCompany().getId()).get();

		coupon.setCompany(company);

		couponsDao.save(coupon);

	}

	/**
	 * @param couponId  Receive a coupon id
	 * @param companyId Receive a company id
	 * @param userData  Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCoupon(long couponId, long companyId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getCompanyId() != companyId)
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(couponId);
		ValidationUtils.isValidId(companyId);

		if (!couponsDao.existsById(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS, ErrorType.COUPON_IS_NOT_EXISTS.getMessage(),
					false);

		if (!companiesDao.existsById(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		// check if coupon belong to company
		if (!couponsDao.existsByIdAndCompanyId(couponId, companyId))
			throw new ApplicationException(ErrorType.GENERAL_ERROR, ErrorType.GENERAL_ERROR.getMessage(), true);

		// delete all children with cascade
		couponsDao.deleteById(couponId);

	}

	/**
	 * @param coupon   Receive a coupon
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 5)
	public void updateCoupon(Coupon coupon, UserDataMap userData) throws ApplicationException {

		if (coupon == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getCompanyId() != coupon.getCompany().getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(coupon.getId());
		ValidationUtils.isValidId(coupon.getCompany().getId());
		ValidationUtils.isValidCategory(coupon.getCategory());
		ValidationUtils.isValidName(coupon.getTitle());
		DateUtils.isValidDate(coupon.getStartDate(), coupon.getEndDate());
		ValidationUtils.isValidAmount(coupon.getAmount());
		ValidationUtils.isValidPrice(coupon.getPrice());
		ValidationUtils.isValidImage(coupon.getImage());

		if (!couponsDao.existsById(coupon.getId()))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS, ErrorType.COUPON_IS_NOT_EXISTS.getMessage(),
					false);

		Coupon couponFromDataBase = couponsDao.findById(coupon.getId()).get();

		if (!couponFromDataBase.getTitle().equals(coupon.getTitle())) {

			if (couponsDao.existsByCompanyIdAndTitle(coupon.getCompany().getId(), coupon.getTitle()))

				throw new ApplicationException(ErrorType.COUPON_IS_ALREADY_EXISTS,
						ErrorType.COUPON_IS_ALREADY_EXISTS.getMessage(), false);

		}

		Company company = companiesDao.findById(coupon.getCompany().getId()).get();
		coupon.setCompany(company);

		couponsDao.save(coupon);

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getAllCoupons(UserDataMap userData) throws ApplicationException {

		// only customer can see coupon list for purchase
		if (!userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		List<Coupon> coupons = new ArrayList<Coupon>();

		couponsDao.findAll().forEach(coupons::add);

		return coupons;

	}

	/**
	 * @param couponId Receive a coupon id
	 * @return This function return a coupon
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Coupon getCoupon(long couponId) throws ApplicationException {

		ValidationUtils.isValidId(couponId);

		if (!couponsDao.existsById(couponId))
			throw new ApplicationException(ErrorType.COUPON_IS_NOT_EXISTS, ErrorType.COUPON_IS_NOT_EXISTS.getMessage(),
					false);

		return couponsDao.findById(couponId).get();

	}

	/**
	 * @param companyId Receive a company id
	 * @param userData  Receive an userData
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByCompanyId(long companyId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getCompanyId() != companyId)
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(companyId);

		if (!companiesDao.existsById(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		return couponsDao.findByCompanyId(companyId);

	}

	/**
	 * @param companyId Receive a company id
	 * @param category  Receive a category
	 * @param userData  Receive an userData
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByCategory(long companyId, Category category, UserDataMap userData)
			throws ApplicationException {

		if (!userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getCompanyId() != companyId)
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(companyId);
		ValidationUtils.isValidCategory(category);

		if (!companiesDao.existsById(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		return couponsDao.findByCompanyIdAndCategory(companyId, category);

	}

	/**
	 * @param companyId Receive a company id
	 * @param maxPrice  Receive a max price
	 * @param userData  Receive an userData
	 * @return This function return a coupon list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Coupon> getCompanyCouponsByMaxPrice(long companyId, double maxPrice, UserDataMap userData)
			throws ApplicationException {

		if (!userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getCompanyId() != companyId)
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(companyId);
		ValidationUtils.isValidPrice(maxPrice);

		if (!companiesDao.existsById(companyId))
			throw new ApplicationException(ErrorType.COMPANY_IS_NOT_EXISTS,
					ErrorType.COMPANY_IS_NOT_EXISTS.getMessage(), false);

		return couponsDao.findByCompanyIdAndPriceLessThanEqual(companyId, maxPrice);

	}

}
