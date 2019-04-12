package coupons.logic;

import java.util.List;

import coupons.beans.Customer;
import coupons.beans.User;
import coupons.dao.CustomersDao;
import coupons.dao.ICustomersDao;
import coupons.dao.IPurchasesDao;
import coupons.dao.IUsersDao;
import coupons.dao.PurchasesDao;
import coupons.dao.UsersDao;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.ValidationUtils;

/**
 * This class manage the all function for customer facade
 * 
 * @author Lichay
 */
public class CustomerController {

	private ICustomersDao customerDao;
	private IPurchasesDao purchasesDao;
	private UserController userController;
	private IUsersDao usersDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public CustomerController() throws ApplicationException {

		customerDao = new CustomersDao();
		purchasesDao = new PurchasesDao();
		userController = new UserController();
		usersDao = new UsersDao();

	}

	/**
	 * @param customer Receive a customer
	 * @return
	 * @throws ApplicationException This function can throw an applicationException
	 */
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

	/**
	 * @param customerId Receive a customer id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCustomer(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		purchasesDao.deletePurchaseByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
		userController.deleteUser(customerId);

	}

	/**
	 * @param customer Receive a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
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

	/**
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Customer> getAllCustomer() throws ApplicationException {

		return customerDao.getAllCustomer();

	}

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Customer getCustomer(long customerId) throws ApplicationException {

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage());

		return customerDao.getCustomer(customerId);

	}

}