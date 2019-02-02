package facade;

import dbdao.CompaniesDBDAO;
import exception.ExceptionName;
import javaBeans.Company;

public class AdminFacade extends ClientFacade {

	@Override
	boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;
		return false;
	}

	public AdminFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
	}

	public void addCompany(Company c) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.create();
		companies.insert(c);
	}

}
