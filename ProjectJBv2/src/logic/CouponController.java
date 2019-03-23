package logic;

import java.util.ArrayList;
import java.util.Date;

import beans.Coupon;
//import dao.CompaniesDao;
import dao.CouponsDao;
import dao.PurchasesDao;
import exception.ApplicationException;

public class CouponController {

	private CouponsDao couponsDao;
	private PurchasesDao purchasesDao;
//	private CompaniesDao companiesDao;

	public CouponController() {
		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
//		companiesDao = new CompaniesDao();

	}

	public void createCoupon(Coupon coupon) throws ApplicationException {

		if (!(coupon.getStartDate().before(coupon.getEndDate()))) {
			throw new ApplicationException("This date isn't well! (must be start date before end date)");
		}
		if (coupon.getEndDate().before(new Date())) {
			throw new ApplicationException("This date isn't well! (end date must be after current date)");
		}
		if (couponsDao.isCouponExists(coupon)) {
			throw new ApplicationException("have a problem:\n" + "This coupon already exist on data base");
		}
		couponsDao.createCoupon(coupon);

	}

	public void deleteCoupon(long couponId) throws ApplicationException {

		if (!couponsDao.isCouponExists(couponId)) {
			throw new ApplicationException("This coupon id isn't exist");
		}

		purchasesDao.refundCouponByCouponId(couponId);

		couponsDao.deleteCoupon(couponId);
	}

	public void updateCoupon(Coupon coupon) throws ApplicationException {

		if (!couponsDao.isCouponExists(coupon.getId())) {
			throw new ApplicationException("This coupon id isn't exist");
		}

		if (!(coupon.getStartDate().before(coupon.getEndDate())))
			throw new ApplicationException("This date isn't well! (must be start date before end date)");

		if (coupon.getEndDate().before(new Date())) {
			throw new ApplicationException("This date isn't well! (end date must be after current date)");
		}
		// add check for update - if can update title and more
		couponsDao.updateCoupon(coupon);
	}

	public ArrayList<Coupon> getAllCoupon() throws ApplicationException {
		return couponsDao.getAllCoupon();

	}

	public Coupon getCoupon(long couponId) throws ApplicationException {

		if (couponsDao.isCouponExists(couponId))
			return couponsDao.getCoupon(couponId);

		throw new ApplicationException("This coupon id isn't exist");
	}

//	public ArrayList<Coupon> getCompanyCouponsById(long companyId) throws ApplicationException {
//		if (companiesDao.isCompanyExists(companyId))
//			return couponsDao.getCompanyCouponsById(companyId);
//
//		throw new ApplicationException("Have a problem:\n" + "This company isn't exist");
//
//	}

	public long howMuchCouponRemain(long couponId) throws ApplicationException {
		if (couponsDao.isCouponExists(couponId))
			return couponsDao.howMuchCouponRemain(couponId);

		throw new ApplicationException("Have a problem:\n" + "This coupon isn't exist");

	}

}
