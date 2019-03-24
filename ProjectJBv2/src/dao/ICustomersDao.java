package dao;

import java.util.ArrayList;

import beans.Customer;
import exception.ApplicationException;

/**
 * This interface will implement by class customersDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICustomersDao {

	/**
	 * @param c Receive a customer and add to data base
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void createCustomer(Customer c) throws ApplicationException;

	/**
	 * @param customerID Receive a customer id and delete from data base
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void deleteCustomer(long customerId) throws ApplicationException;

	/**
	 * @param c Receive a customer and update his details
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	void updateCustomer(Customer c) throws ApplicationException;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return Check if customer exists and return true or false
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	public boolean isCustomerExists(String email, String password) throws ApplicationException;

	/**
	 * @param customerId Receive an id
	 * @return Check if customer exists and return true or false
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	public boolean isCustomerExists(long customerId) throws ApplicationException;

	/**
	 * @return This function return all customer from data base
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	ArrayList<Customer> getAllCustomer() throws ApplicationException;

	/**
	 * @param customerID Receive a customer id
	 * @return This function return customer by his id
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	Customer getCustomer(long customerId) throws ApplicationException;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return a customer by his email and password
	 * @throws ApplicationException Can throw an ApplicationException
	 */
	Customer getCustomerByEmailAndPassword(String email, String password) throws ApplicationException;

}
