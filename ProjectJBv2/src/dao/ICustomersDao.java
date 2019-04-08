package dao;

import java.util.List;

import beans.Customer;
import exception.ApplicationException;

public interface ICustomersDao {

	public long createCustomer(Customer customer) throws ApplicationException;

	public void deleteCustomer(long customerId) throws ApplicationException;

	public void updateCustomer(Customer customer) throws ApplicationException;

	public List<Customer> getAllCustomer() throws ApplicationException;

	public boolean isCustomerExists(long customerId) throws ApplicationException;

	public Customer getCustomer(long customerId) throws ApplicationException;

}
