package dao;

import baseProgram.Customer;

public interface ICustomersDAO extends IMainDAO {

	void insert(Customer c) throws Exception;

	void delete(int indexToDelete) throws Exception;

	void update(Customer c, int index) throws Exception;

	public boolean isCustomerExists(String email, String password) throws Exception;

	Customer getOneCustomer(int customerID) throws Exception;
}
