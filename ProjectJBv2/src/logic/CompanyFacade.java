package logic;

import java.util.ArrayList;

import beans.Category;
import beans.Company;
import beans.Coupon;
import dbdao.CompaniesDao;
import dbdao.CouponsDao;
import exception.ExceptionName;

/**
 * This class manage the all function for company facade
 * 
 * @author Lichay
 */
public class CompanyFacade extends ClientFacade {

	private long companyID;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password and check if login succeed
	 * @throws ExceptionName Can throw an exception by name
	 */
	public CompanyFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CompaniesDao customer = new CompaniesDao();
		try {
			this.companyID = customer.getCompanyByEmailAndPassword(email, password).getId();
			System.out.println("you are login: " + companyID);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Constructor for company facade
	 */
	public CompanyFacade() {
		super();
	}

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return true if login succeed
	 */

	@Override
	boolean login(String email, String password) {
		CompaniesDao companies = new CompaniesDao();
		try {
			if (companies.isCompanyExists(email, password))
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * @param c Receive a coupon and add to company list inside data base
	 * @throws Exception Can throw an exception
	 */
	public void addCoupon(Coupon c) throws Exception {
		CouponsDao coupon = new CouponsDao();
		coupon.insert(c);
	}

	/**
	 * @param c Receive a coupon and update it
	 * @throws Exception Can throw an exception
	 */
	public void updateCoupon(Coupon c) throws Exception {
		CouponsDao coupon = new CouponsDao();
		coupon.update(c);
	}

	/**
	 * @param couponid Receive a coupon id and delete it from data base
	 * @throws Exception Can throw an exception
	 */
	public void deleteCoupon(long couponid) throws Exception {
//		CouponsDao coupon = new CouponsDao();
//		coupon.delete(couponid, companyID);
	}

	/**
	 * @return This function return all coupons from login company
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCoupons() throws Exception {
		CouponsDao coupon = new CouponsDao();
		return coupon.getCompanyCouponsById(companyID);
	}

	/**
	 * @param category Receive a category
	 * @return This function return all coupon list that have a same category , in
	 *         company login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCoupons(Category category) throws Exception {
		CouponsDao coupon = new CouponsDao();
		return coupon.getCompanyCouponsByCategory(category, companyID);
	}

	/**
	 * @param maxPrice Receive a max price
	 * @return This function return all coupons that have lower price then max price
	 *         , in company login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws Exception {
		CouponsDao coupon = new CouponsDao();
		return coupon.getCompanyCouponsByMaxPrice(maxPrice, companyID);
	}

	/**
	 * @return This function return the company that login
	 */
	public Company getCompanyDetails() {
		CompaniesDao companies = new CompaniesDao();
		try {
			return companies.getCompany(companyID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}