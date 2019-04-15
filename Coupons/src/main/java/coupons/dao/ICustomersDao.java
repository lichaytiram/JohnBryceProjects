package coupons.dao;

import java.util.List;

import coupons.beans.Customer;
import coupons.exception.ApplicationException;

public interface ICustomersDao {

	/**
	 * @param customer Receive a customer
	 * @return This function return an id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public long createCustomer(Customer customer) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void deleteCustomer(long customerId) throws ApplicationException;

	/**
	 * @param customer Receive a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public void updateCustomer(Customer customer) throws ApplicationException;

	/**
	 * @return This function return customer list
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public List<Customer> getAllCustomer() throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @return This function return true if customer exists
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public boolean isCustomerExists(long customerId) throws ApplicationException;

	/**
	 * @param customerId Receive a customer id
	 * @return This function return a customer
	 * @throws ApplicationException This function can throw an applicationException
	 */
	public Customer getCustomer(long customerId) throws ApplicationException;

}
