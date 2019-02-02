package facade;

import dao.ICompaniesDAO;
import dao.ICustomersDAO;
import dao.ICouponsDAO;

public abstract class ClientFacade {
	ICompaniesDAO CompaniesDAO;
	ICustomersDAO CustomersDAO;
	ICouponsDAO CouponsDAO;

	abstract boolean login(String email, String password);
}
