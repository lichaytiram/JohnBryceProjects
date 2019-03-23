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
}
