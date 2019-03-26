package logic;

import java.util.List;

import beans.Customer;
import beans.User;
import dao.CustomerDao;
import dao.PurchasesDao;
import exception.ApplicationException;

/**
 * This class manage the all function for customer facade
 * 
 * @author Lichay
 */
public class CustomerController {

	private CustomerDao customerDao;
	private PurchasesDao purchasesDao;
	private UserController userController;

	public CustomerController() throws ApplicationException {
		customerDao = new CustomerDao();
		purchasesDao = new PurchasesDao();
		userController = new UserController();
	}

	public void createCustomer(Customer customer) throws ApplicationException {
		if (customerDao.isCustomerExists(customer.getEmail(), customer.getPassword())) {
			throw new ApplicationException("Have a problem:\n" + "This customer exist!");
		}
		User u = customer.getUser();

		long id = userController.createUser(u);

		customer.setId(id);
		customerDao.createCustomer(customer);

	}

	public void deleteCustomer(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId)) {
			return;
		}

		purchasesDao.refundCouponByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
		userController.d

	}

	public void updateCustomer(Customer customer) throws ApplicationException {

		if (customerDao.isCustomerExists(customer.getId())) {
			if (customerDao.isCustomerExists(customer.getEmail(), customer.getPassword())) {
				throw new ApplicationException("Have a problem:\n" + "This customer does exist");
			}
			customerDao.updateCustomer(customer);
		} else {
			throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");
		}
	}

	public List<Customer> getAllCustomer() throws ApplicationException {
		return customerDao.getAllCustomer();
	}

	public Customer getCustomer(long customerId) throws ApplicationException {
		if (customerDao.isCustomerExists(customerId)) {
			return customerDao.getCustomer(customerId);
		}

		throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");
	}

	public Customer getCustomerByEmailAndPassword(String email, String password) throws ApplicationException {
		if (customerDao.isCustomerExists(email, password)) {
			return customerDao.getCustomerByEmailAndPassword(email, password);
		}

		throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");
	}

}