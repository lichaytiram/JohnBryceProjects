package dao;

import java.util.ArrayList;

import javaBeans.Customer;

public interface ICustomersDAO extends IMainDAO {

	void insert(Customer c) throws Exception;

	void delete(int customerID) throws Exception;

	void update(Customer c) throws Exception;

	public boolean isCustomerExists(String email, String password) throws Exception;

	ArrayList<Customer> getAllCustomer() throws Exception;

	Customer getOneCustomer(int customerID) throws Exception;
}
