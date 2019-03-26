package demo;

import beans.Customer;
import beans.User;
import enums.ClientType;
import exception.ApplicationException;
import logic.CustomerController;
import test.RefreshDataBase;

public class DemoMain {

	private static CustomerController customer = null;

	public static void main(String[] args) {

		RefreshDataBase refreshDataBase = new RefreshDataBase();
		refreshDataBase.refreshDB();

		try {
			customer = new CustomerController();
			Customer c1 = new Customer("omer", "marh", "ww@gmai.com", "1sSd");
			c1.setUser(new User("x", "x", null, ClientType.Customer));
			customer.createCustomer(c1);
			Customer c2 = new Customer("omerr", "marhs", "wsw@gmai.com", "1sSd");
			c2.setUser(new User("x1", "x1", null, ClientType.Customer));
			customer.createCustomer(c2);

			customer.deleteCustomer(1);
			System.out.println(customer.getAllCustomer());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}
