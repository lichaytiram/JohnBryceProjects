package facade;

import java.util.ArrayList;

import beans.Category;
import beans.Company;
import beans.Coupon;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import exception.ExceptionName;

/**
 * This class manage the all function for company facade
 * 
 * @author Lichay
 */
public class CompanyFacade extends ClientFacade {

	private int companyID;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password and check if login succeed
	 * @throws ExceptionName Can throw an exception by name
	 */
	public CompanyFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CompaniesDBDAO customer = new CompaniesDBDAO();
		try {
			this.companyID = customer.getOneCompanyByEmailAndPassword(email, password).getId();
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
		CompaniesDBDAO companies = new CompaniesDBDAO();
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
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.insert(c);
	}

	/**
	 * @param c Receive a coupon and update it
	 * @throws Exception Can throw an exception
	 */
	public void updateCoupon(Coupon c) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.update(c);
	}

	/**
	 * @param couponid Receive a coupon id and delete it from data base
	 * @throws Exception Can throw an exception
	 */
	public void deleteCoupon(int couponid) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.delete(couponid, companyID);
	}

	/**
	 * @return This function return all coupons from login company
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCoupons() throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		return coupon.getCompanyCouponsByID(companyID);
	}

	/**
	 * @param category Receive a category
	 * @return This function return all coupon list that have a same category , in
	 *         company login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCoupons(Category category) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		return coupon.getCompanyCouponsByCategory(category, companyID);
	}

	/**
	 * @param maxPrice Receive a max price
	 * @return This function return all coupons that have lower price then max price
	 *         , in company login
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		return coupon.getCompanyCouponsByMaxPrice(maxPrice, companyID);
	}

	/**
	 * @return This function return the company that login
	 */
	public Company getCompanyDetails() {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		try {
			return companies.getOneCompany(companyID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}