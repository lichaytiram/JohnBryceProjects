package logic;

import java.util.List;

import beans.Customer;
import beans.User;
import dao.CustomerDao;
import dao.PurchasesDao;
import dao.UsersDao;
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
	private UsersDao usersDao;

	public CustomerController() throws ApplicationException {
		customerDao = new CustomerDao();
		purchasesDao = new PurchasesDao();
		userController = new UserController();
		usersDao = new UsersDao();
	}

	public void createCustomer(Customer customer) throws ApplicationException {

		if (usersDao.isUserExist(customer.getUser().getUserName()))
			throw new ApplicationException("Have a problem:\n" + "This customer exist!");

		User user = customer.getUser();

		long id = userController.createUser(user);

		customer.setId(id);
		customer.getUser().setId(id);

		customerDao.createCustomer(customer);

	}

	public void deleteCustomer(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");

		purchasesDao.deleteCouponByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
		userController.deleteUser(customerId);

	}

	public void updateCustomer(Customer customer) throws ApplicationException {

		if (customer.getId() != customer.getUser().getId())
			throw new ApplicationException("Have a problem:\n" + "This user id invalid!");

		if (!customerDao.isCustomerExists(customer.getId()))
			throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");

		customerDao.updateCustomer(customer);
		// maybe need check about user

	}

	public List<Customer> getAllCustomer() throws ApplicationException {
		return customerDao.getAllCustomer();
	}

	public Customer getCustomer(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException("Have a problem:\n" + "This customer doesn't exist");

		return customerDao.getCustomer(customerId);
	}

}