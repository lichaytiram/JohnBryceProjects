package logic;

import dao.ICompaniesDao;
import dao.ICustomersDao;
import dao.ICouponsDao;

/**
 * This abstract class that will be implement by loginManager
 * 
 * @author Lichay
 *
 */
public abstract class ClientFacade {
	ICompaniesDao CompaniesDAO;
	ICustomersDao CustomersDAO;
	ICouponsDao CouponsDAO;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return true if login succeed
	 */
	abstract boolean login(String email, String password);
}
