package facade;

import java.util.ArrayList;
import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import exception.ExceptionName;
import javaBeans.Category;
import javaBeans.Company;
import javaBeans.Coupon;

public class CompanyFacade extends ClientFacade {

	private int companyID;

	public CompanyFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CompaniesDBDAO customer = new CompaniesDBDAO();
		try {
			this.companyID = customer.getOneCompanyByEmailAndPassword(email, password).getId();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

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

	public void addCoupon(Coupon c) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.insert(c);
	}

	public void updateCoupon(Coupon c) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.update(c);
	}

	public void deleteCoupon(int couponid) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.delete(couponid);
	}

	public ArrayList<Coupon> getCompanyCoupons() throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		return coupon.getCompanyCouponsByID(companyID);
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		return coupon.getCompanyCouponsByCategory(category, companyID);
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		return coupon.getCompanyCouponsByIdAndMaxPrice(maxPrice, companyID);
	}

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