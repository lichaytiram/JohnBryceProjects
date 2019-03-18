package logic;

import java.util.ArrayList;

import beans.Company;
import beans.Customer;
import daily.job.Job;
import dao.CompaniesDao;
import dao.CustomerDao;
import exception.ApplicationException;

/**
 * This class manage the all function for admin facade
 * 
 * @author Lichay
 */
public class AdminFacade extends ClientFacade {

	/**
	 * @param email    Receive an email
	 * @param password Receive a password and check if login succeed
	 * @throws ApplicationException Can throw an exception by name
	 */
	public AdminFacade(String email, String password) throws ApplicationException {
		if (!login(email, password))
			throw new ApplicationException("Don't have a match with your current email and password!");
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
		CompaniesDao companies = new CompaniesDao();
		companies.createCompany(c);
	}

	/**
	 * @param c Receive a company and update from data base
	 * @throws Exception Can throw an exception
	 */
	public void updateCompany(Company c) throws Exception {
		CompaniesDao companies = new CompaniesDao();
		companies.updateCompany(c);
	}

	/**
	 * @param companyID Receive company id and delete it from data base
	 * @throws Exception Can throw an exception
	 */
	public void deleteCompany(int companyID) throws Exception {
		CompaniesDao companies = new CompaniesDao();
		companies.deleteCompany(companyID);
	}

	/**
	 * @return This function return all companies from data base
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Company> getAllCompanies() throws Exception {
		CompaniesDao companies = new CompaniesDao();
		return companies.getAllCompany();
	}

	/**
	 * @param companyID Receive a company id
	 * @return This function return a company by his company id
	 * @throws Exception Can throw an exception
	 */
	public Company getOneCompany(int companyID) throws Exception {
		CompaniesDao companies = new CompaniesDao();
		return companies.getCompany(companyID);
	}

	/**
	 * @param c Receive a customer and add to data base
	 * @throws Exception Can throw an exception
	 */
	public void addCustomer(Customer c) throws Exception {
		CustomerDao Customer = new CustomerDao();
		Customer.createCustomer(c);
	}

	/**
	 * @param c Receive a customer and update from data base
	 * @throws Exception Can throw an exception
	 */
	public void updateCustomer(Customer c) throws Exception {
		CustomerDao Customer = new CustomerDao();
		Customer.updateCustomer(c);
	}

	/**
	 * @param customerID Receive a customer id and delete from data base
	 * @throws Exception Can throw an exception
	 */
	public void deleteCustomer(int customerID) throws Exception {
		CustomerDao Customer = new CustomerDao();
		Customer.deleteCustomer(customerID);
	}

	/**
	 * @return This function return the all customers from data base
	 * @throws Exception Can throw an exception
	 */
	public ArrayList<Customer> getAllCustomer() throws Exception {
		CustomerDao Customer = new CustomerDao();
		return Customer.getAllCustomer();
	}

	/**
	 * @param customerID Receive an id
	 * @return This function return a customer from data base by his id
	 * @throws Exception Can throw an exception
	 */
	public Customer getOneCustomer(int customerID) throws Exception {
		CustomerDao Customer = new CustomerDao();
		return Customer.getCustomer(customerID);
	}

	/**
	 * This function stop daily job
	 */
	public void stopDailyJob() {
		daily.job.Job job = new Job();
		job.stop();
	}

}
