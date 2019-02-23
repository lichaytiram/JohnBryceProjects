package facade;

import exception.ExceptionName;

/**
 * This class create option to login as admin , company or customer
 * 
 * @author Lichay
 *
 */
public class LoginManager {

	private static LoginManager log = new LoginManager();

	/**
	 * @return This function return an instance for this class
	 */
	public static LoginManager getInstance() {
		return log;
	}

	/**
	 * Empty constructor
	 */
	private LoginManager() {
	}

	/**
	 * @param email      Receive an email
	 * @param password   Receive a password
	 * @param clientType Receive a clientType
	 * @return This function return a ClientFacade type
	 * @throws ExceptionName
	 */
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
