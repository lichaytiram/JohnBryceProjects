package logic;

import java.util.List;

import beans.Customer;
import beans.User;
import dao.CustomersDao;
import dao.PurchasesDao;
import dao.UsersDao;
import enums.ErrorType;
import exception.ApplicationException;
import utils.EmailUtils;
import utils.IdUtils;
import utils.NameUtils;
import utils.PasswordUtils;
import utils.PhoneNumberUtils;
import utils.TypeUtils;

/**
 * This class manage the all function for customer facade
 * 
 * @author Lichay
 */
public class CustomerController {

	private CustomersDao customerDao;
	private PurchasesDao purchasesDao;
	private UserController userController;
	private UsersDao usersDao;

	public CustomerController() throws ApplicationException {

		customerDao = new CustomersDao();
		purchasesDao = new PurchasesDao();
		userController = new UserController();
		usersDao = new UsersDao();

	}

	public void createCustomer(Customer customer) throws ApplicationException {

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (customer.getUser() == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		NameUtils.isValidName(customer.getFirstName());
		PhoneNumberUtils.isValidPhoneNumber(customer.getPhoneNumber());
		EmailUtils.isValidEmail(customer.getEmail());
		NameUtils.isValidName(customer.getUser().getUserName());
		PasswordUtils.isValidPassword(customer.getUser().getPassword());
		TypeUtils.isValidType(customer.getUser().getType());

		if (usersDao.isUserExist(customer.getUser().getUserName()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage());

		User user = customer.getUser();

		long id = userController.createUser(user);

		customer.setId(id);
		customer.getUser().setId(id);

		customerDao.createCustomer(customer);

	}

	public void deleteCustomer(long customerId) throws ApplicationException {

		IdUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
		userController.deleteUser(customerId);

	}

	public void updateCustomer(Customer customer) throws ApplicationException {

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (customer.getUser() == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		IdUtils.isValidId(customer.getId());
		NameUtils.isValidName(customer.getFirstName());
		PhoneNumberUtils.isValidPhoneNumber(customer.getPhoneNumber());
		EmailUtils.isValidEmail(customer.getEmail());
		IdUtils.isValidId(customer.getUser().getId());
		NameUtils.isValidName(customer.getUser().getUserName());
		PasswordUtils.isValidPassword(customer.getUser().getPassword());
		TypeUtils.isValidType(customer.getUser().getType());

		if (!customerDao.isCustomerExists(customer.getId()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		User userFromDataBase = usersDao.getUser(customer.getId());

		if (!userFromDataBase.getUserName().equals(customer.getUser().getUserName())) {

			if (usersDao.isUserExist(customer.getUser().getUserName()))

				throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage());

		}

		customerDao.updateCustomer(customer);

	}

	public List<Customer> getAllCustomer() throws ApplicationException {

		return customerDao.getAllCustomer();

	}

	public Customer getCustomer(long customerId) throws ApplicationException {

		IdUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return customerDao.getCustomer(customerId);

	}

}