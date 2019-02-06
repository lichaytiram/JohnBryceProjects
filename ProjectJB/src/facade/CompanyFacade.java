package facade;

import dbdao.CompaniesDBDAO;
import dbdao.CouponsDBDAO;
import exception.ExceptionName;
import javaBeans.Coupon;

public class CompanyFacade extends ClientFacade {

	private int companyID;

	public CompanyFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
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

	public void delete(int couponID) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.delete(couponID);
	}

}