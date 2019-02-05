package facade;

import dbdao.CouponsDBDAO;
import exception.ExceptionName;
import javaBeans.Coupon;

public class CompanyFacade extends ClientFacade {

	public CompanyFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
	}

	@Override
	boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;
		return false;
	}

	public void addCoupon(Coupon c) throws Exception {
		CouponsDBDAO coupon = new CouponsDBDAO();
		coupon.insert(c);
	}
	
	
	
	
}