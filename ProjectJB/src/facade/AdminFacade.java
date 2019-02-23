package facade;

import java.util.ArrayList;

import dbdao.CompaniesDBDAO;
import dbdao.CustomerDBDAO;
import exception.ExceptionName;
import javaBeans.Company;
import javaBeans.Customer;

/**
 * This class manage the all function for admin facade
 * 
 * @author Lichay
 */
public class AdminFacade extends ClientFacade {

	/**
	 * @param email    Receive an email
	 * @param password Receive a password and check if login succeed
	 * @throws ExceptionName Can throw an exception by name
	 */
	public AdminFacade(String email, String password) throws ExceptionName {
		if (!login(email, password))
			throw new ExceptionName("Don't have a match with your current email and password!");
		System.out.println("You are login: as admin");
	}

	/**
	 * Constructor for admin facade
	 */
	public AdminFacade() {

	}

	/**
	 * @param email    Receive an email
	 * @param password Receive a password
	 * @return This function return true if login succeed
	 */
	@Override
	boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;
		return false;
	}

	/**
	 * @param c Receive a company and add to data base
	 * @throws Exception Can throw an exception
	 */
	public void addCompany(Company c) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.insert(c);
	}

	/**
	 * @param c Receive a company and update from data base
	 * @throws Exception Can throw an exception
	 */
	public void updateCompany(Company c) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.update(c);
	}

	/**
	 * @param companyID Receive company id and delete it from data base
	 * @throws Exception Can throw an exception
	 */
	public void deleteCompany(int companyID) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		companies.delete(companyID);
	}

	/**
	 * @return This function return all companies from data base
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Company> getAllCompanies() throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		return companies.getAllCompany();
	}

	/**
	 * @param companyID Receive a company id
	 * @return This function return a company by his company id
	 * @throws Exception Can throw an exception
	 */
	public Company getOneCompany(int companyID) throws Exception {
		CompaniesDBDAO companies = new CompaniesDBDAO();
		return companies.getOneCompany(companyID);
	}

	/**
	 * @param c Receive a customer and add to data base
	 * @throws Exception Can throw an exception
	 */
	public void addCustomer(Customer c) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		Customer.insert(c);
	}

	/**
	 * @param c Receive a customer and update from data base
	 * @throws Exception Can throw an exception
	 */
	public void updateCustomer(Customer c) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		Customer.update(c);
	}

	/**
	 * @param customerID Receive a customer id and delete from data base
	 * @throws Exception Can throw an exception
	 */
	public void deleteCustomer(int customerID) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		Customer.delete(customerID);
	}

	/**
	 * @return This function return the all customers from data base
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Customer> getAllCustomer() throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		return Customer.getAllCustomer();
	}

	/**
	 * @param customerID Receive an id
	 * @return This function return a customer from data base by his id
	 * @throws Exception Can throw an exception
	 */
	public Customer getOneCustomer(int customerID) throws Exception {
		CustomerDBDAO Customer = new CustomerDBDAO();
		return Customer.getOneCustomer(customerID);
	}

}
