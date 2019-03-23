package logic;

import java.util.ArrayList;

import beans.Company;
import dao.CompaniesDao;
import dao.CouponsDao;
import dao.PurchasesDao;
import exception.ApplicationException;

/**
 * This class manage the all function for company facade
 * 
 * @author Lichay
 */
public class CompanyController {

	private CompaniesDao companiesDao;
	private CouponsDao couponsDao;
	private PurchasesDao purchasesDao;

	public CompanyController() throws ApplicationException {
		companiesDao = new CompaniesDao();
		couponsDao = new CouponsDao();
		purchasesDao = new PurchasesDao();
	}

	public void createCompany(Company company) throws ApplicationException {
		CompaniesDao companiesDao = new CompaniesDao();

		if (companiesDao.isCompanyExistsByName(company.getName())) {
			throw new ApplicationException("Have a problem:\n" + "This company exist!");
		}
		companiesDao.createCompany(company);
	}

	public void deleteCompany(long companyId) throws ApplicationException {
		ArrayList<Long> list = new ArrayList<>();

		if (!companiesDao.isCompanyExists(companyId)) {
			return;
		}

		list = couponsDao.getAllCouponsIdByCompanyId(companyId);
		while (list.size() > 0) {

			purchasesDao.refundCouponByCouponId(list.get(0));
			list.remove(0);

		}
		couponsDao.deleteCouponbyCompanyId(companyId);
		companiesDao.deleteCompany(companyId);

	}

	public void updateCompany(Company company) throws ApplicationException {
		if (companiesDao.isCompanyExistsByName(company.getName())) {
			throw new ApplicationException("Have a problem:\n" + "This company exist");
		}
		companiesDao.updateCompany(company);
	}

	public ArrayList<Company> getAllCompany() throws ApplicationException {
		return companiesDao.getAllCompany();
	}

	public Company getCompany(long companyId) throws ApplicationException {
		if (companiesDao.isCompanyExists(companyId)) {
			return companiesDao.getCompany(companyId);
		}
		throw new ApplicationException("Have a problem:\n" + "This company exist");

	}

	public Company getCompanyByEmailAndPassword(String email, String password) throws ApplicationException {
		if (companiesDao.isCompanyExists(email, password)) {
			return companiesDao.getCompanyByEmailAndPassword(email, password);
		}
		throw new ApplicationException("Have a problem:\n" + "This company exist");
	}

//
//	/**
//	 * @param c Receive a coupon and add to company list inside data base
//	 * @throws Exception Can throw an exception
//	 */
//	public void addCoupon(Coupon c) throws Exception {
//		CouponsDao coupon = new CouponsDao();
//		coupon.createCoupon(c);
//	}
//
//	/**
//	 * @param c Receive a coupon and update it
//	 * @throws Exception Can throw an exception
//	 */
//	public void updateCoupon(Coupon c) throws Exception {
//		CouponsDao coupon = new CouponsDao();
//		coupon.updateCoupon(c);
//	}
//
//	/**
//	 * @param couponid Receive a coupon id and delete it from data base
//	 * @throws Exception Can throw an exception
//	 */
//	public void deleteCoupon(long couponid) throws Exception {
////		CouponsDao coupon = new CouponsDao();
////		coupon.delete(couponid, companyID);
//	}
//
//	/**
//	 * @return This function return all coupons from login company
//	 * @throws Exception Can throw an exception
//	 */
//	public ArrayList<Coupon> getCompanyCoupons() throws Exception {
//		CouponsDao coupon = new CouponsDao();
//		return coupon.getCompanyCouponsById(companyID);
//	}
//
//	/**
//	 * @param category Receive a category
//	 * @return This function return all coupon list that have a same category , in
//	 *         company login
//	 * @throws Exception Can throw an exception
//	 */
//	public ArrayList<Coupon> getCompanyCoupons(Category category) throws Exception {
//		CouponsDao coupon = new CouponsDao();
//		return coupon.getCompanyCouponsByCategory(category, companyID);
//	}
//
//	/**
//	 * @param maxPrice Receive a max price
//	 * @return This function return all coupons that have lower price then max price
//	 *         , in company login
//	 * @throws Exception Can throw an exception
//	 */
//	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws Exception {
//		CouponsDao coupon = new CouponsDao();
//		return coupon.getCompanyCouponsByMaxPrice(maxPrice, companyID);
//	}
//
//	/**
//	 * @return This function return the company that login
//	 */
//	public Company getCompanyDetails() {
//		CompaniesDao companies = new CompaniesDao();
//		try {
//			return companies.getCompany(companyID);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return null;
//
//	}

}