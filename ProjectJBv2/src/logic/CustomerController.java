package logic;

import java.util.List;

import beans.Customer;
import beans.User;
import dao.CustomerDao;
import dao.PurchasesDao;
import dao.UsersDao;
import enums.ErrorType;
import exception.ApplicationException;
import utils.EmailUtils;
import utils.IdUtils;
import utils.NameUtils;
import utils.PhoneNumberUtils;

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

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		NameUtils.isValidName(customer.getFirstName());
		NameUtils.isValidName(customer.getUser().getUserName());
		PhoneNumberUtils.isValidPhoneNumber(customer.getPhoneNumber());
		EmailUtils.isValidEmail(customer.getEmail());

		if (usersDao.isUserExist(customer.getUser().getUserName()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage());

		User user = customer.getUser();

		long id = userController.createUser(user);

		customer.setId(id);
		customer.getUser().setId(id);

		customerDao.createCustomer(customer);

	}

	public void deleteCustomer(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
		userController.deleteUser(customerId);

	}

	public void updateCustomer(Customer customer) throws ApplicationException {

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		IdUtils.isValidId(customer.getId());
		NameUtils.isValidName(customer.getFirstName());
		NameUtils.isValidName(customer.getUser().getUserName());
		PhoneNumberUtils.isValidPhoneNumber(customer.getPhoneNumber());
		EmailUtils.isValidEmail(customer.getEmail());

		if (!customerDao.isCustomerExists(customer.getId()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		customerDao.updateCustomer(customer);

	}

	public List<Customer> getAllCustomer() throws ApplicationException {
		return customerDao.getAllCustomer();
	}

	public Customer getCustomer(long customerId) throws ApplicationException {

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return customerDao.getCustomer(customerId);
	}

}