package facade;

import dbdao.CustomerDBDAO;
import exception.ExceptionName;
import javaBeans.Customer;

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
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			if (customer.isCustomerExists(email, password))
				return true;
		} catch (Exception e) {
		}
		return false;
	}

	public void addCouponPurchase(int customerId, int couponId) throws Exception {

	}

	public Customer getCustomerDetails() {
		CustomerDBDAO customer = new CustomerDBDAO();
		try {
			return customer.getOneCustomer(customerID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

}