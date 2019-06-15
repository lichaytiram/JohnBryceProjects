package coupons.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import coupons.beans.Customer;
import coupons.beans.Name;
import coupons.beans.User;
import coupons.beans.UserDataMap;
import coupons.dao.ICustomersDao;
import coupons.dao.IPurchasesDao;
import coupons.dao.IUsersDao;
import coupons.enums.ErrorType;
import coupons.exception.ApplicationException;
import coupons.utils.ValidationUtils;

/**
 * This class manage the all function for customer facade
 * 
 * @author Lichay
 */
@Controller
public class CustomerController {

	@Autowired
	private ICustomersDao customerDao;
	@Autowired
	private IUsersDao usersDao;

//	/**
//	 * @param customer Receive a customer
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void createCustomer(Customer customer) throws ApplicationException {
//
//		if (customer == null)
//			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);
//
//		if (customer.getUser() == null)
//			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);
//
//		ValidationUtils.isValidName(customer.getFirstName());
//		ValidationUtils.isValidPhoneNumber(customer.getPhoneNumber());
//		ValidationUtils.isValidEmail(customer.getEmail());
//		ValidationUtils.isValidName(customer.getUser().getUserName());
//		ValidationUtils.isValidPassword(customer.getUser().getPassword());
//		ValidationUtils.isValidType(customer.getUser().getType());
//
//		if (usersDao.existsByUserName(customer.getUser().getUserName()))
//			throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS,
//					ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage(), false);
//
//		User user = customer.getUser();
//
//		long id = usersDao.createUser(user); // return generate key
//
//		customer.setId(id);
//		customer.getUser().setId(id);
//
//		customerDao.save(customer);
//
//	}

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

		if (!customerDao.existsById(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		if (!usersDao.existsById(customerId))
			throw new ApplicationException(ErrorType.USER_IS_NOT_EXISTS, ErrorType.USER_IS_NOT_EXISTS.getMessage(),
					false);

		customerDao.deleteById(customerId);

	}

//	/**
//	 * @param customer Receive a customer
//	 * @param userData Receive an userData
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public void updateCustomer(Customer customer, UserDataMap userData) throws ApplicationException {
//
//		if (customer == null)
//			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);
//
//		if (customer.getUser() == null)
//			throw new ApplicationException(ErrorType.EMPTY, ErrorType.EMPTY.getMessage(), false);
//
//		if (!userData.getClientType().name().equals("Customer"))
//			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);
//
//		if (customer.getId() != userData.getId())
//			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);
//
//		if (userData.getClientType().name().equals("Administrator")
//				|| userData.getClientType().name().equals("Company"))
//			throw new ApplicationException(ErrorType.FIELD_IS_IRREPLACEABLE,
//					ErrorType.FIELD_IS_IRREPLACEABLE.getMessage(), false);
//
//		User userToUpdate = customer.getUser();
//
//		ValidationUtils.isValidId(customer.getId());
//		ValidationUtils.isValidName(customer.getFirstName());
//		ValidationUtils.isValidPhoneNumber(customer.getPhoneNumber());
//		ValidationUtils.isValidEmail(customer.getEmail());
//		ValidationUtils.isValidId(userToUpdate.getId());
//		ValidationUtils.isValidName(userToUpdate.getUserName());
//		ValidationUtils.isValidPassword(userToUpdate.getPassword());
//		ValidationUtils.isValidType(userToUpdate.getType());
//
//		if (!customerDao.existsById(customer.getId()))
//			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
//					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);
//
//		User userFromDataBase = usersDao.findById(customer.getId()).get();
//
//		if (!userFromDataBase.getUserName().equals(customer.getUser().getUserName())) {
//
//			if (usersDao.existsByUserName(customer.getUser().getUserName()))
//
//				throw new ApplicationException(ErrorType.CUSTOMER_IS_ALREADY_EXISTS,
//						ErrorType.CUSTOMER_IS_ALREADY_EXISTS.getMessage(), false);
//
//		}
//
//		usersDao.updateUser(userToUpdate.getUserName(), userToUpdate.getPassword(), userToUpdate.getId()); // wait avi
//																											// answer
//		customerDao.save(customer);
//
//	}

	/**
	 * @param userData Receive an userData
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Customer> getAllCustomers(UserDataMap userData) throws ApplicationException {

		if (!userData.getClientType().name().equals("Administrator"))
			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);

		List<Customer> customers = new ArrayList<Customer>();

		customerDao.findAll().forEach(customers::add);

		return customers;

	}

//	/**
//	 * @param customerId Receive a customer id
//	 * @param userData   Receive an userData
//	 * @return This function return customer list
//	 * @throws ApplicationException This function can throw an applicationException
//	 */
//	public Name getCustomerName(long customerId, UserDataMap userData) throws ApplicationException {
//
//		if (!userData.getClientType().name().equals("Customer"))
//			throw new ApplicationException(ErrorType.INVALID_ACCESS, ErrorType.INVALID_ACCESS.getMessage(), false);
//
//		if (customerId != userData.getId())
//			throw new ApplicationException(ErrorType.SCAM, ErrorType.SCAM.getMessage(), true);
//
//		ValidationUtils.isValidId(customerId);
//
//		if (!customerDao.existsById(customerId))
//			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
//					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);
//
//		String name = customerDao.getCustomerName(customerId);
//
//		Name myName = new Name(name);
//
//		return myName;
//
//	}

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

		if (!customerDao.existsById(customerId))
			throw new ApplicationException(ErrorType.CUSTOMER_IS_NOT_EXISTS,
					ErrorType.CUSTOMER_IS_NOT_EXISTS.getMessage(), false);

		return customerDao.findById(customerId).get();

	}

}