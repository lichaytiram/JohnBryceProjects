package coupons.logic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import coupons.beans.Customer;
import coupons.beans.Name;
import coupons.beans.User;
import coupons.beans.UserDataMap;
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
@Controller
@Service
public class CustomerController {

	private ICustomersDao customerDao;
	private IPurchasesDao purchasesDao;
	private IUsersDao usersDao;

	/**
	 * This function instantiate all references
	 * 
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public CustomerController() throws ApplicationException {

		customerDao = new CustomersDao();
		purchasesDao = new PurchasesDao();
		usersDao = new UsersDao();

	}

	/**
	 * @param customer Receive a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void createCustomer(Customer customer) throws ApplicationException {

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (customer.getUser() == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		ValidationUtils.isValidName(customer.getFirstName());
		ValidationUtils.isValidPhoneNumber(customer.getPhoneNumber());
		ValidationUtils.isValidEmail(customer.getEmail());
		ValidationUtils.isValidName(customer.getUser().getUserName());
		ValidationUtils.isValidPassword(customer.getUser().getPassword());
		ValidationUtils.isValidType(customer.getUser().getType());

		if (usersDao.isUserExist(customer.getUser().getUserName()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS,
					ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage(), false);

		User user = customer.getUser();

		long id = usersDao.createUser(user);

		customer.setId(id);
		customer.getUser().setId(id);

		customerDao.createCustomer(customer);

	}

	/**
	 * @param customerId Receive a customer id
	 * @param userData   Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCustomer(long customerId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);

		if (customerId != userData.getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		if (!usersDao.isUserExist(customerId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		purchasesDao.deletePurchaseByCustomerId(customerId);
		customerDao.deleteCustomer(customerId);
		usersDao.deleteUser(customerId);

	}

	/**
	 * @param customer Receive a customer
	 * @param userData Receive an userData
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCustomer(Customer customer, UserDataMap userData) throws ApplicationException {

		if (customer == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (customer.getUser() == null)
			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);

		if (!userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);

		if (customer.getId() != userData.getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		if (userData.getClientType().name().equals("Administrator")
				|| userData.getClientType().name().equals("Company"))
			throw new ApplicationException(ErrorType.FIELD_IS_IRREPLACEABLE,
					ErrorType.FIELD_IS_IRREPLACEABLE.getMessage(), false);

		User userToUpdate = customer.getUser();

		ValidationUtils.isValidId(customer.getId());
		ValidationUtils.isValidName(customer.getFirstName());
		ValidationUtils.isValidPhoneNumber(customer.getPhoneNumber());
		ValidationUtils.isValidEmail(customer.getEmail());
		ValidationUtils.isValidId(userToUpdate.getId());
		ValidationUtils.isValidName(userToUpdate.getUserName());
		ValidationUtils.isValidPassword(userToUpdate.getPassword());
		ValidationUtils.isValidType(userToUpdate.getType());

		if (!customerDao.isCustomerExists(customer.getId()))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		User userFromDataBase = usersDao.getUser(customer.getId());

		if (!userFromDataBase.getUserName().equals(customer.getUser().getUserName())) {

			if (usersDao.isUserExist(customer.getUser().getUserName()))

				throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS,
						ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage(), false);

		}

		usersDao.updateUser(userToUpdate.getUserName(), userToUpdate.getPassword(), userToUpdate.getId());
		customerDao.updateCustomer(customer);

	}

	/**
	 * @param userData Receive an userData
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Customer> getAllCustomers(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		return customerDao.getAllCustomers();

	}

	/**
	 * @param customerId Receive a customer id
	 * @param userData   Receive an userData
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Name getCustomerName(long customerId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);

		if (customerId != userData.getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		String name = customerDao.getCustomerName(customerId);

		Name myName = new Name(name);

		return myName;

	}

	/**
	 * @param customerId Receive a customer id
	 * @param userData   Receive an userData
	 * @return This function return customer name
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Customer getCustomer(long customerId, UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Customer"))
			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);

		if (customerId != userData.getId())
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		ValidationUtils.isValidId(customerId);

		if (!customerDao.isCustomerExists(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		return customerDao.getCustomer(customerId);

	}

}