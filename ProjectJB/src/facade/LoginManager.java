package facade;

import dao.ICompaniesDAO;
import dao.ICustomersDAO;
import exception.ExceptionName;

public class LoginManager {

	private ICompaniesDAO CompaniesDAO;
	private ICustomersDAO CustomersDAO;

	private static LoginManager log = new LoginManager();

	public static LoginManager getInstance() {
		return log;
	}

	private LoginManager() {

	}

	public ClientFacade login(String email, String password, ClientType clientType) throws ExceptionName {

		if (clientType.equals(ClientType.Administrator))
			return new AdminFacade(email, password);
		else if (clientType.equals(ClientType.Company))
			return new CompanyFacade(email, password);
		else if (clientType.equals(ClientType.Customer))
			return new CustomerFacade(email, password);
		else
			return null;
	}
}
