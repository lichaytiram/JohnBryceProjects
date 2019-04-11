package logic;

import java.util.List;

import beans.Customer;
import beans.User;
import dao.CustomersDao;
import dao.PurchasesDao;
import dao.UsersDao;
import enums.ErrorType;
import exception.ApplicationException;
import utils.ValidationUtils;

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

	public long createCustomer(Customer customer) throws ApplicationException {

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		if (customer.getUser() == null)
			throw new ApplicationException(ErrorType.EMPTY.getMessage());

		ValidationUtils.isValidName(customer.getFirstName());
		ValidationUtils.isValidPhoneNumber(customer.getPhoneNumber());
		ValidationUtils.isValidEmail(customer.getEmail());
		ValidationUtils.isValidName(customer.getUser().getUserName());
		ValidationUtils.isValidPassword(customer.getUser().getPassword());
		ValidationUtils.isValidType(customer.getUser().getType());

		if (usersDao.isUserExist(customer.getUser().getUserName()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage());

		User user = customer.getUser();

		long id = userController.createUser(user);

		customer.setId(id);
		customer.getUser().setId(id);

		return customerDao.createCustomer(customer);

	}

	public void deleteCustomer(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

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

		ValidationUtils.isValidId(customer.getId());
		ValidationUtils.isValidName(customer.getFirstName());
		ValidationUtils.isValidPhoneNumber(customer.getPhoneNumber());
		ValidationUtils.isValidEmail(customer.getEmail());
		ValidationUtils.isValidId(customer.getUser().getId());
		ValidationUtils.isValidName(customer.getUser().getUserName());
		ValidationUtils.isValidPassword(customer.getUser().getPassword());
		ValidationUtils.isValidType(customer.getUser().getType());

		if (!customerDao.isCustomerExists(customer.getId()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		User userFromDataBase = usersDao.getUser(customer.getId());

		if (!userFromDataBase.getUserName().equals(customer.getUser().getUserName())) {

			if (usersDao.isUserExist(customer.getUser().getUserName()))

				throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage());

		}

		User userToUpdate = customer.getUser();

		usersDao.updateUser(userToUpdate.getUserName(), userToUpdate.getPassword(), userToUpdate.getId());
		customerDao.updateCustomer(customer);

	}

	public List<Customer> getAllCustomer() throws ApplicationException {

		return customerDao.getAllCustomer();

	}

	public Customer getCustomer(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return customerDao.getCustomer(customerId);

	}

}