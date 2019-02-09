package facade;

import dbdao.CustomerDBDAO;
import exception.ExceptionName;

public class CustomerFacade extends ClientFacade {

	private int customerID;

	public CustomerFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			this.customerID = customer.getOneCustomerByEmailAndPassword(email, password).getId();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;
		return false;
	}

}