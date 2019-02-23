package facade;

import dao.ICompaniesDAO;
import dao.ICustomersDAO;
import dao.ICouponsDAO;

/**
 * This abstract class that will be implement by loginManager
 * 
 * @author Lichay
 *
 */
public abstract class ClientFacade {
	ICompaniesDAO CompaniesDAO;
	ICustomersDAO CustomersDAO;
	ICouponsDAO CouponsDAO;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return true if login succeed
	 */
	abstract boolean login(String email, String password);
}
