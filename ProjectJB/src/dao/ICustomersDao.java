package dao;

import java.util.ArrayList;

import beans.Customer;

/**
 * This interface will implement by class customersDBDAO
 * 
 * @author Lichay
 *
 */
public interface ICustomersDao extends IMainDao {

	/**
	 * @param c Receive a customer and add to data base
	 * @throws Exception Can throw an exception
	 */
	void insert(Customer c) throws Exception;

	/**
	 * @param customerID Receive a customer id and delete from data base
	 * @throws Exception Can throw an exception
	 */
	void delete(int customerID) throws Exception;

	/**
	 * @param c Receive a customer and update his details
	 * @throws Exception Can throw an exception
	 */
	void update(Customer c) throws Exception;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return Check if customer exists and return true or false
	 * @throws Exception Can throw an exception
	 */
	public boolean isCustomerExists(String email, String password) throws Exception;

	/**
	 * @return This function return all customer from data base
	 * @throws Exception Can throw an exception
	 */
	ArrayList<Customer> getAllCustomer() throws Exception;

	/**
	 * @param customerID Receive a customer id
	 * @return This function return customer by his id
	 * @throws Exception Can throw an exception
	 */
	Customer getOneCustomer(int customerID) throws Exception;

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return a customer by his email and password
	 * @throws Exception Can throw an exception
	 */
	Customer getOneCustomerByEmailAndPassword(String email, String password) throws Exception;

}
